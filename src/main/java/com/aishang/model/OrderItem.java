package com.aishang.model;

public class OrderItem {
    private Integer itemid;
    private Integer count;
    private double subtotal;
    private Integer pid;
    private Integer oid;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid=" + itemid +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", pid=" + pid +
                ", oid='" + oid + '\'' +
                '}';
    }
}
