package com.aishang.controller;

import com.aishang.model.*;

import com.aishang.service.ICategoryService;
import com.aishang.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import java.util.List;


@Controller
@RequestMapping("/product")

public class ProductController {

    @Resource
    private IProductService productService;
    @Resource
    private ICategoryService categoryService;


    @RequestMapping("/productInf")
    public String productInf(Integer pid, Model model){
        ProductImageExt proInf = productService.findProInf(pid);
        List<CategoryExt> category = categoryService.findCategory();
        model.addAttribute("proInf",proInf);
        model.addAttribute("category",category);

        return "productInformation";
    }





   }



