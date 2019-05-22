package com.aishang.service;


import com.aishang.model.PageBeanForCate;

import com.aishang.model.ProductImageExt;


public interface IProductService {
     //查询商品
     void findProByCate(PageBeanForCate pageBean);


     //商品详情
     ProductImageExt findProInf(Integer pid);
}
