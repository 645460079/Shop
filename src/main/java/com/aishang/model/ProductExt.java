package com.aishang.model;


public class ProductExt extends Product{
    private CategoryExt categoryExt;


    public CategoryExt getCategoryExt() {
        return categoryExt;
    }

    public void setCategoryExt(CategoryExt categoryExt) {
        this.categoryExt = categoryExt;
    }
}
