package com.example.practicaBBX2.Controller;

import com.example.practicaBBX2.Model.StateItemEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class ItemDTO implements Serializable {

    private Long itemid;
    private Integer itemCode;
    private String description;
    private Integer price;
    private StateItemEnum state;
    private Set<SupplierDTO> suppliers;
    private Set<PriceReductionDTO> priceReductions;
    private Date creationDate;
    private UserDTO creator;


    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public StateItemEnum getState() {
        return state;
    }

    public void setState(StateItemEnum state) {
        this.state = state;
    }

    public Set<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<PriceReductionDTO> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(Set<PriceReductionDTO> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }
}
