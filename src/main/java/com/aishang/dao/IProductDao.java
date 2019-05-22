package com.aishang.dao;

import com.aishang.model.*;


import java.util.List;

public interface IProductDao {
    //l查询商品
    List<ProductExt> findProByCate(PageBeanForCate pageBean);



    //获取总记录数
    Integer getRowCount(PageBeanForCate pageBean);


    //商品详情
    ProductImageExt findProInf(Integer pid);




}
