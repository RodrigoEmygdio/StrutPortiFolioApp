package org.example.portfolio.usermanagement.entities;

import java.io.Serializable;

public class Portfolio implements Serializable {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
