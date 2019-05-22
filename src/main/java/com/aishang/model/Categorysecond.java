package com.aishang.model;

import java.util.List;

public class Categorysecond extends ProductImage{
    private Integer csid;
    private String csname;
    private Integer cid;
    private Integer csstate;
    private List<ProductImage> productImages;

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCsstate() {
        return csstate;
    }

    public void setCsstate(Integer csstate) {
        this.csstate = csstate;
    }

    @Override
    public String toString() {
        return "Categorysecond{" +
                "csid=" + csid +
                ", csname='" + csname + '\'' +
                ", cid=" + cid +
                ", csstate=" + csstate +
                '}';
    }
}
