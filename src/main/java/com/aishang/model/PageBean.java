package com.aishang.model;

import java.util.List;

public class PageBean<T> {

    private List<T> container;
    private  Integer pageNow=1;
    private  Integer pageSize;
    private  Integer pageCount;
    private  Integer rowCount;


    public List<T> getContainer() {
        return container;
    }

    public void setContainer(List<T> container) {
        this.container = container;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;

        /*计算pageCount*/
        if (rowCount%pageSize==0){
            pageCount=rowCount/pageSize;
        }else{
            pageCount=rowCount/pageSize+1;
        }
        /*计算pageNow*/
        if (pageNow>pageCount){
            pageNow=pageCount;
        }
        if (pageNow<0){
            pageNow=1;
        }



    }

    public Integer getStartIndex() {

        if (getPageNow()!=0&&getPageNow()!=null){
            return (getPageNow()-1)*pageSize;
        }
        return 1;
    }








}
