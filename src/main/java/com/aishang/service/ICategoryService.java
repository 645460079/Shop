package com.aishang.service;

import com.aishang.model.Category;
import com.aishang.model.CategoryExt;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategory();

    List<CategoryExt> findCategory();

}
