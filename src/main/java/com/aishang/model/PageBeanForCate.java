package com.aishang.model;

public class PageBeanForCate<T> extends PageBean<T>{
    private Integer cid;
    private Integer csid;
    private String pname;



    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "PageBeanForCate{" +
                "cid=" + cid +
                ", csid=" + csid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
