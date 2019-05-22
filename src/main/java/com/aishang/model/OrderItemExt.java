package com.aishang.model;

public class OrderItemExt extends OrderItem {

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    @Override
    public String toString() {
        return "OrderItemExt{" +
                "product=" + product +
                '}';
    }
}
