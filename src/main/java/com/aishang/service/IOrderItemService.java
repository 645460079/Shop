package com.aishang.service;

import com.aishang.model.OrderItem;
import com.aishang.model.Orders;

public interface IOrderItemService {
    void addOrderItem(OrderItem orderItem);

    void addOrders(Orders order);
}
