package com.aishang.controller;

import com.aishang.model.CategoryExt;
import com.aishang.model.PageBeanForCate;


import com.aishang.service.ICategoryService;
import com.aishang.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/category")
public class CategoryController {


    @Resource
    private IProductService productService;
    @Resource
    private ICategoryService categoryService;
    //查询商品
    @RequestMapping("/selectP")
    public String selectP(PageBeanForCate pageBean, Model model) {

        productService.findProByCate(pageBean);
        List<CategoryExt> category = categoryService.findCategory();
        model.addAttribute("category", category);
        model.addAttribute("proByCate", pageBean);
        return "productCategory";
    }


}
