package com.aishang.model;

import java.util.List;

public class OrdersExt extends Orders{
    public List<OrderItemExt> getOrderItemExtList() {
        return orderItemExtList;
    }

    public void setOrderItemExtList(List<OrderItemExt> orderItemExtList) {
        this.orderItemExtList = orderItemExtList;
    }

    private List<OrderItemExt> orderItemExtList;

    @Override
    public String toString() {
        return "OrdersExt{" +
                "orderItemExtList=" + orderItemExtList +
                '}';
    }
}
