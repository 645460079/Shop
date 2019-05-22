package com.aishang.dao;

import com.aishang.model.OrderItem;
import com.aishang.model.Orders;

public interface IOrderItemDao {
    void addOrderItem(OrderItem orderItem);

    void addOrders(Orders order);
}
