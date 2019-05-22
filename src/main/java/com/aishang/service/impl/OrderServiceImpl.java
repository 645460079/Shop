package com.aishang.service.impl;

import com.aishang.dao.IOrderDao;

import com.aishang.model.Cities;

import com.aishang.model.OrdersExt;
import com.aishang.model.PageBeanForOrder;
import com.aishang.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderDao orderDao;


    @Override
    public List<Cities> findCities(Integer parentid) {
        return orderDao.findCities(parentid);
    }

    @Override
    public List<Cities> findProvincial() {
        return orderDao.findProvincial();
    }

    @Override
    public PageBeanForOrder<OrdersExt> findOrders(PageBeanForOrder<OrdersExt> pageBeanForOrder) {
        pageBeanForOrder.setPageSize(3);
       //设置记录数
        Integer rowCount = orderDao.findOrdersCount(pageBeanForOrder);
        pageBeanForOrder.setRowCount(rowCount);
        pageBeanForOrder.setContainer(orderDao.findOrdersByUid(pageBeanForOrder));


        return pageBeanForOrder;
    }

    @Override
    public OrdersExt findOrdersById(Integer oid) {
        return orderDao.findOrdersById(oid);
    }

    @Override
    public void updateState(OrdersExt ordersExt) {
         orderDao.updateState(ordersExt);
    }
    @Override
    public int getOidInt(){
        int str =Integer.parseInt(new SimpleDateFormat("yyyyMMddhh").format(new Date()));
        int rannum = (int) (new Random().nextDouble() * (999 - 100 + 1)) + 100;// 获取2位随机数
        return  str+rannum;
}
}
