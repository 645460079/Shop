package com.aishang.model;

import java.util.List;

public class CategoryExt extends Category {
    private List<Categorysecond> categoryseconds;

    public List<Categorysecond> getCategoryseconds() {
        return categoryseconds;
    }

    public void setCategoryseconds(List<Categorysecond> categoryseconds) {
        this.categoryseconds = categoryseconds;
    }
}
