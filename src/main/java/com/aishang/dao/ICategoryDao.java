package com.aishang.dao;

import com.aishang.model.Category;
import com.aishang.model.CategoryExt;

import java.util.List;

public interface ICategoryDao {
// 查询一级类目
    List<Category> findAllCategory();

//根据一级目录查询二级

    List<CategoryExt> findCategory();

}


