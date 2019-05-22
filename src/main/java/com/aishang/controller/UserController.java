package com.aishang.controller;

import com.aishang.model.User;
import com.aishang.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
//隔离路径
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private HttpSession session;

    @RequestMapping("/userName")
    public void userName(HttpServletResponse response,String username) throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println(username+"添加用户js");
        User user = userService.findUserByName(username);
        if(user==null){
            out.println("yes");
        }else {
            out.println("no");
        }

    }

    @RequestMapping("/updatePersonal")
    public String updatePersonal(User user){
        System.out.println(user);
       userService.updatePersonal(user);
        User userById = userService.findUserById(user.getUid());
        session.setAttribute("sess",userById);
        return "userInformation";
    }

}