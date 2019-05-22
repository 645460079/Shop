package com.aishang.model;

public class CartItem {
    private Product product;
    private int proCount;
    private double total;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProCount() {
        return proCount;
    }

    public void setProCount(int proCount) {
        this.proCount = proCount;
    }

    public double getTotal() {
        return product.getShop_price()*proCount;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", proCount=" + proCount +
                ", total=" + total +
                '}';
    }
}
