package com.example.practicaBBX2.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierid;
    private String name;
    private String country;

    private Long item_id;
    @ManyToMany
    @JoinTable(
            name = "itemsupplier",
            joinColumns = @JoinColumn(name = "supplier_id",updatable=false, insertable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id",updatable=false, insertable = false)
    )
    private Set<Item> items;

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

    public Set<Item> getItems() { return items; }

    public void setItems(Set<Item> items) { this.items = items; }
}
