package com.aishang.dao;


import com.aishang.model.Cities;
import com.aishang.model.OrdersExt;
import com.aishang.model.PageBeanForOrder;

import java.util.List;

public interface IOrderDao {


   List<Cities> findCities(Integer parentid);

   List<Cities> findProvincial();

   //查询用户下的订单个数
   Integer findOrdersCount(PageBeanForOrder<OrdersExt> pageBeanForOrder);

   //查询用户的订单列表
   List<OrdersExt> findOrdersByUid(PageBeanForOrder<OrdersExt> pageBeanForOrder);

    OrdersExt findOrdersById(Integer oid);

   void updateState(OrdersExt ordersExt);
}
