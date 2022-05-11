package com.example.practicaBBX2.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pricereductions")
public class PriceReduction  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pricereductionid;
    private Integer reducedPrice;
    private Date startDate;
    private Date endDate;

    private Long item_id;
    @ManyToMany
    @JoinTable(
            name = "itempricered",
            joinColumns = @JoinColumn(name = "pricereduction_id",updatable=false, insertable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id",updatable=false, insertable = false)
    )
    private Set<Item> items;

    public Long getPricereductionid() { return pricereductionid; }

    public void setPricereductionid(Long pricereductionid) { this.pricereductionid = pricereductionid; }

    public Integer getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Integer reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getItem_id() { return item_id; }

    public void setItem_id(Long item_id) { this.item_id = item_id; }

    public Set<Item> getItems() { return items; }

    public void setItems(Set<Item> items) { this.items = items; }
}
