package com.aishang.model;

import java.util.HashMap;

import java.util.Map;

public class Cart {
    private Map<Integer,CartItem> cartItemMap = new HashMap<>();
    private  double subTotal;

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public double getSubTotal() {

        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }


    public void addCartItem(CartItem cartItem) {
        System.out.println(cartItem);
        Integer pid = cartItem.getProduct().getPid();
        if (cartItemMap.containsKey(pid)) {
            CartItem oldcartItem = cartItemMap.get(pid);
            int oldproCount = oldcartItem.getProCount();
            int newproCount = cartItem.getProCount();
            cartItem.setProCount(oldproCount + newproCount);
            cartItemMap.put(pid, cartItem);

            subTotal = (subTotal - oldproCount * cartItem.getProduct().getShop_price()) + cartItem.getTotal();
        } else {
            cartItemMap.put(pid, cartItem);

            subTotal = subTotal + cartItem.getTotal();
        }

    }



    public  void delCartItem(Integer pid){

        subTotal=subTotal-cartItemMap.get(pid).getTotal();
        cartItemMap.remove(pid);


    }

    public void delAll() {
        subTotal=0;
        cartItemMap.clear();

    }

        @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                ", subTotal=" + subTotal +
                '}';
    }


}
