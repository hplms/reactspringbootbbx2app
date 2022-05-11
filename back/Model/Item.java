package com.example.practicaBBX2.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemid;
    @NotNull
    @Column(unique = true)
    private Integer itemCode;
    @NotEmpty
    private String description;
    private Integer price;
    private StateItemEnum state;

    private Date creationDate;

    private Long pricereduction_id;
    private Long supplier_id;
    private Long user_id;

    @ManyToMany(mappedBy = "items",cascade=CascadeType.ALL)
    private Set<Supplier> suppliers;

    @ManyToMany(mappedBy = "items",cascade=CascadeType.ALL)
    private Set<PriceReduction> priceReductions;

    @ManyToOne
    @JoinColumn(name="user_id",updatable=false, insertable = false)
    private User creator;

    public Long getItemid() {return itemid; }

    public void setItemid(Long itemid) {this.itemid = itemid; }

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

    public Set<Supplier> getSuppliers() { return suppliers; }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(Set<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreator() { return creator; }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Long getPricereduction_id() { return pricereduction_id; }

    public void setPricereduction_id(Long pricereduction_id) { this.pricereduction_id = pricereduction_id; }

    public Long getSupplier_id() { return supplier_id; }

    public void setSupplier_id(Long supplier_id) { this.supplier_id = supplier_id; }

    public Long getUser_id() { return user_id; }

    public void setUser_id(Long user_id) { this.user_id = user_id; }
}
