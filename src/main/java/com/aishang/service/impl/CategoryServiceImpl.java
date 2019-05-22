package com.aishang.service.impl;

import com.aishang.dao.ICategoryDao;

import com.aishang.model.Category;

import com.aishang.model.CategoryExt;
import com.aishang.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {


    @Resource
    //注入CategoryDao
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }

    @Override
    public List<CategoryExt> findCategory() {
        return  categoryDao.findCategory();
    }


}
