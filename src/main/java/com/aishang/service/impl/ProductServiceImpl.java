package com.aishang.service.impl;

import com.aishang.dao.IProductDao;
import com.aishang.model.*;
import com.aishang.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {
    @Resource
    //注入productDao
    private IProductDao productDao;

    @Override
    public void findProByCate(PageBeanForCate pageBean) {
        pageBean.setPageSize(12);

        Integer rowCount = productDao.getRowCount(pageBean);
        pageBean.setRowCount(rowCount);

        List<ProductExt> proByCate = productDao.findProByCate(pageBean);
        pageBean.setContainer(proByCate);


    }

    @Override
    public ProductImageExt findProInf(Integer pid) {
        return productDao.findProInf(pid);
    }


}
