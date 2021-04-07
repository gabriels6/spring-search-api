package com.searchapi.api.request.body;

import java.io.Serializable;

public class CategoryBody implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
