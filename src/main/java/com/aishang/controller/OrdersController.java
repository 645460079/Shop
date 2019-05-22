package com.aishang.controller;


import com.aishang.model.*;
import com.aishang.service.*;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/order")
public class OrdersController {
    @Resource
    private IOrderService orderService;
    @Resource
    private IUserService userService;
    @Resource
    private IOrderItemService orderItemService;
    @Resource
    private ICategoryService categoryService;
    @Resource
    private IProductService productService;



    @RequestMapping("/orderIndex")
        public String orderIndex(HttpServletRequest request, Model model,Integer[] hobby,CartItem cartItem){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("sess");

        if(user!=null) {
            String[] addres = user.getAddr().split("-");
            System.out.println(addres[0] + "++" + addres[1] + "++" + addres[2]);
            session.setAttribute("a", addres[0]);
            session.setAttribute("b", addres[1]);
            session.setAttribute("c", addres[2]);
        }
        List<Cities> provincials = orderService.findProvincial();

        Cart cart = (Cart)session.getAttribute("cart");
        int oid =orderService.getOidInt();

        Cart carts = new Cart();

        System.out.println(hobby[0]+";;;;;;;;;;;;;;;;");


        for(int i = 0; i <hobby.length ; i++) {
            if(session.getAttribute("cart")==null||cart.getCartItemMap().get(hobby[i])==null){
                ProductImageExt product = productService.findProInf(hobby[i]);
                cartItem.setProduct(product);

                cart= new Cart();
                cart.addCartItem(cartItem);


            }
            System.out.println(cart.getCartItemMap().get(hobby[i]));
            carts.getCartItemMap().put(hobby[i], cart.getCartItemMap().get(hobby[i]));
            carts.setSubTotal(carts.getSubTotal()+carts.getCartItemMap().get(hobby[i]).getProduct().getShop_price()*carts.getCartItemMap().get(hobby[i]).getProCount());
    }
        session.setAttribute("cart",carts);
        Collection<CartItem> cartItems = carts.getCartItemMap().values();

        model.addAttribute("oid",oid);
        model.addAttribute("cartItems",cartItems);
        model.addAttribute("provincials",provincials);
        return "confirmOrder";
    }
        @ResponseBody
        @RequestMapping("/cities")
        public String cities(Integer parentid) {

            List<Cities> citynames = orderService.findCities(parentid);
            System.out.println(citynames.toString());
            JSONArray jsonArray = JSONArray.fromObject(citynames);
            System.out.println(jsonArray.toString());

            return jsonArray.toString();
        }

        @ResponseBody
        @RequestMapping("/update")
        public String update(User user, String proname, String cityname, String area,HttpSession session) {
            System.out.println(proname);
            user.setAddr(proname+"-"+cityname+"-"+area);

            userService.updateAddr(user);
            User userById = userService.findUserById(user.getUid());
            session.setAttribute("sess",userById);
            JSONArray jsonArray = JSONArray.fromObject(userById);


           return jsonArray.toString();

        }

        @RequestMapping("/submitOrder")
        public String submitOrder(HttpSession session,Integer oid,Integer[] pid,Model model){
            Cart cart =(Cart)session.getAttribute("cart");
            User user =(User)session.getAttribute("sess");

            Orders order = new Orders();
            order.setName(user.getName());
            order.setAddr(user.getAddr());
            order.setPhone(user.getPhone());
            order.setOid(oid);
            order.setState(0);
            order.setTotal(cart.getSubTotal());
            order.setUid(user.getUid());
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            order.setOrdertime(date);
            orderItemService.addOrders(order);
            OrderItem orderItem = new OrderItem();
            for (int i = 0; i <cart.getCartItemMap().values().size(); i++) {

                orderItem.setOid(oid);
                orderItem.setCount(cart.getCartItemMap().get(pid[i]).getProCount());
                orderItem.setSubtotal(cart.getCartItemMap().get(pid[i]).getProCount()*cart.getCartItemMap().get(pid[i]).getProduct().getShop_price());
                orderItem.setPid(pid[i]);
                orderItemService.addOrderItem(orderItem);
            }

            model.addAttribute("oid",oid);

            return "submitOrderView";
        }

        //我的订单
        @RequestMapping("/myOrders")
        public String myOrders(Model model,PageBeanForOrder<OrdersExt> pageBeanForOrder,HttpSession session){
            if(session.getAttribute("sess")==null){
                return "redirect:/user/login.do";
            }

            PageBeanForOrder<OrdersExt> orders = orderService.findOrders(pageBeanForOrder);
            System.out.println(orders.getContainer().toString());
            List<CategoryExt> category = categoryService.findCategory();

            model.addAttribute("orders",orders);
            model.addAttribute("category",category);
            return "myOrdersView";
        }


        //支付成功 及 订单回显
        @RequestMapping("/payNow")
        public String payNow(Integer oid,Model model){
            OrdersExt ordersExt = orderService.findOrdersById(oid);
            ordersExt.setState(1);
            orderService.updateState(ordersExt);
            model.addAttribute("ordersExt",ordersExt);

            return "paySuccessView";
        }

        //我的订单去付款
        @RequestMapping("/goPay")
        public String goPay(Integer oid,Model model){
            model.addAttribute("oid",oid);
            return "submitOrderView";
        }

        //个人中心
        @RequestMapping("/personal")
        public String personal(Model model){
            List<CategoryExt> category = categoryService.findCategory();
            model.addAttribute("category",category);
            return "userInformation";
        }

//        //立即购买
//        @RequestMapping("/shoppingNow")
//        public String shoppingNow(HttpSession session,Model model,Integer hobby){
//
//            User user = (User)session.getAttribute("sess");
//
//            if(user!=null) {
//                String[] addres = user.getAddr().split("-");
//
//                session.setAttribute("a", addres[0]);
//                session.setAttribute("b", addres[1]);
//                session.setAttribute("c", addres[2]);
//            }
//            List<Cities> provincials = orderService.findProvincial();
//            Cart cart = (Cart)session.getAttribute("cart");
//            Cart carts = new Cart();
//            int oid = orderService.getOidInt();
//            carts.getCartItemMap().put(hobby,cart.getCartItemMap().get(hobby));
//            carts.setSubTotal(carts.getSubTotal()+carts.getCartItemMap().get(hobby).getProduct().getShop_price()*carts.getCartItemMap().get(hobby).getProCount());
//            session.setAttribute("cart",carts);
//            Collection<CartItem> cartItems = carts.getCartItemMap().values();
//
//            model.addAttribute("oid",oid);
//            model.addAttribute("cartItems",cartItems);
//            model.addAttribute("provincials",provincials);
//            return "submitOrderView";
//        }
}
