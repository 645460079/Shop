package com.aishang.service.impl;


import com.aishang.dao.IOrderItemDao;
import com.aishang.model.OrderItem;
import com.aishang.model.Orders;
import com.aishang.service.IOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService {
    @Resource
    private IOrderItemDao orderItemDao;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemDao.addOrderItem(orderItem);
    }

    @Override
    public void addOrders(Orders order) {
        orderItemDao.addOrders(order);
    }
}
