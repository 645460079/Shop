package com.aishang.controller;

import com.aishang.model.Cart;
import com.aishang.model.CartItem;
import com.aishang.model.ProductImageExt;
import com.aishang.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import java.util.Map;


@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    private IProductService productService;

    //添加购物车
    @RequestMapping("/addcart")
    public void addcart(CartItem cartItem, Integer pid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ProductImageExt product = productService.findProInf(pid);
        cartItem.setProduct(product);

        if(session.getAttribute("cart")==null){
            Cart cart = new Cart();
            cart.addCartItem(cartItem);
            session.setAttribute("cart",cart);
        }else {
            Cart cart1 = (Cart)session.getAttribute("cart");
            cart1.addCartItem(cartItem);

        }
        out.print("yes");


}


    @RequestMapping("/cartIndex")
    public String cartIndex(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart != null) {
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        Collection<CartItem> mapValues = cartItemMap.values();
        model.addAttribute("mapValues",mapValues);
        }

        return "shoppingcar";
    }



    @RequestMapping("/del")
    public void del(Integer pid,HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        PrintWriter out = response.getWriter();
        cart.delCartItem(pid);
        out.println("yes");
        session.setAttribute("cart",cart);


    }

    @RequestMapping("/delAllJs")
    public void delAllJs(HttpServletResponse response,HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        cart.delAll();
        out.println("yes");
        session.setAttribute("cart",cart);

    }

    @RequestMapping("/jian")
    public void jian(Integer pCount,HttpSession session,Integer pid) {
        Cart cart = (Cart)session.getAttribute("cart");
        CartItem cartItem = cart.getCartItemMap().get(pid);
        if (pCount != null && pCount > 0) {
            cartItem.setProCount(pCount);
        }
        System.out.println(cart.getCartItemMap().get(pid));
        session.setAttribute("cart",cart);

    }
    @RequestMapping("/jia")
    public void jia(Integer pCount,HttpSession session,Integer pid) {
        Cart cart = (Cart)session.getAttribute("cart");
        CartItem cartItem = cart.getCartItemMap().get(pid);
        cartItem.setProCount(pCount);
        System.out.println(cart.getCartItemMap().get(pid));
        session.setAttribute("cart",cart);

    }
}
