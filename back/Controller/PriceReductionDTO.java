package com.example.practicaBBX2.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class PriceReductionDTO  implements Serializable {

    private Long pricereductionid;
    private Integer reducedPrice;
    private Date startDate;
    private Date endDate;
    private Long item_id;
    @JsonIgnore
    private Set <ItemDTO> items;

    public Long getPricereductionid() { return pricereductionid; }

    public void setPricereductionid(Long pricereductionid) { this.pricereductionid = pricereductionid; }

    public Set<ItemDTO> getItem() { return items; }

    public void setItem(Set <ItemDTO> items) { this.items = items; }

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
}
