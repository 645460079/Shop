package com.aishang.model;


public class PageBeanForOrder<OrdersExt> extends  PageBean<OrdersExt> {
    private Integer uid;
    private Integer state;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PageBeanForOrder{" +
                "uid=" + uid +
                ", state=" + state +
                '}';
    }
}
