package com.aishang.service;


import com.aishang.model.Cities;
import com.aishang.model.OrdersExt;
import com.aishang.model.PageBeanForOrder;

import java.util.List;

public interface IOrderService {

  List<Cities> findCities(Integer parentid);
  List<Cities> findProvincial();
  PageBeanForOrder<OrdersExt> findOrders(PageBeanForOrder<OrdersExt> pageBeanForOrder);


    OrdersExt findOrdersById(Integer oid);

  void updateState(OrdersExt ordersExt);

  int getOidInt();
}
