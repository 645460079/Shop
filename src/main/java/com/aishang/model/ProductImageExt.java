package com.aishang.model;

import java.util.List;

public class ProductImageExt extends Product{
    private List<ProductImage> productImage;


    public List<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<ProductImage> productImage) {
        this.productImage = productImage;
    }
}
