package com.example.practicaBBX2.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

public class SupplierDTO  implements Serializable {

    private Long supplierid;
    private String name;
    private String country;
    private Long item_id;
    @JsonIgnore
    private Set<ItemDTO> items;

    public Long getSupplierid() { return supplierid; }

    public void setSupplierid(Long supplierid) { this.supplierid = supplierid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getItem_id() { return item_id; }

    public void setItem_id(Long item_id) { this.item_id = item_id; }
}
