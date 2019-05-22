package com.aishang.controller;

import cn.dsna.util.images.ValidateCode;
import com.aishang.model.Category;
import com.aishang.model.CategoryExt;
import com.aishang.model.User;
import com.aishang.service.ICategoryService;
import com.aishang.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


@Controller
@RequestMapping("/user")
public class DoLogin {

    //注入UserService
    @Resource
    private IUserService userService;

    @Resource
    private ICategoryService categoryService;

    //注入Session
    @Resource
    private HttpSession session;

    @RequestMapping("/login")
    public String login(User user, HttpServletResponse response, String rem,Model model) throws UnsupportedEncodingException {

        User u = userService.selectUser(user);


        //当没有这个客户时，返回登陆页面
        if (u == null) {
            return "login";
        } else {
            //登陆成功
            List<Category> categorys = categoryService.findAllCategory();
            List<CategoryExt> categoryseconds = categoryService.findCategory();
            System.out.println(categorys);
            model.addAttribute("categorys",categorys);
            model.addAttribute("categoryseconds",categoryseconds);


            //存入session
            session.setAttribute("sess", u);
            Cookie cookie = new Cookie("user", URLEncoder.encode((user.getUsername() + "-" + user.getPassword()), "UTF-8"));
            if (cookie != null) {
                if (rem != null) {
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }

            return "index";
        }
    }
    //返回首页
    @RequestMapping("/goIndex")
    public String goIndex(Model model){
        List<Category> categorys = categoryService.findAllCategory();
        List<CategoryExt> categoryseconds = categoryService.findCategory();
        model.addAttribute("categorys",categorys);
        model.addAttribute("categoryseconds",categoryseconds);
        return "index";
    }





    @RequestMapping("/reg")
    public String reg() {
        return "register";

    }


    @RequestMapping("/register")
    public String register(User user, String asd1) {


        String code = (String) session.getAttribute("code");


            System.out.println("系统验证码："+code);
            System.out.println("用户输入的验证码："+asd1);
            if(!code.equals(asd1)){
            return "register";
        }

        if ((user.getUsername() != null &&! user.getUsername() .equals("")) &&
                (user.getPassword() != null &&! user.getPassword().equals("")) &&
                (user.getEmail() != null &&! user.getEmail().equals("")) &&
                (user.getPhone() != null &&! user.getPhone().equals(""))) {

                userService.registerUser(user);


            }else{
            return "register";


            }


        return "login";
    }

    @RequestMapping("/log")
    public String log() {

        return "login";
    }


    @RequestMapping("/yzmdemo")
    public void yzmdemo(HttpServletResponse response,Model model) throws IOException {
        ValidateCode vc = new ValidateCode(150, 50, 4, 20);
        String code = vc.getCode();

        session.setAttribute("code",code);

        model.addAttribute("c",code);
        vc.write(response.getOutputStream());
    }




}