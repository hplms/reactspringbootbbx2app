package com.example.practicaBBX2.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

public class UserDTO implements Serializable {


    private Long userid;
    private String firstName;
    private String secondName;
    private Long item_id;
    @JsonIgnore
    private Set<ItemDTO> items;
    private String username;
    private String password;


    public Long getUserid() { return userid; }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<ItemDTO> getItem() {
        return items;
    }

    public void setItem(Set<ItemDTO> item) {
        this.items = item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getItem_id() { return item_id; }

    public void setItem_id(Long item_id) { this.item_id = item_id; }
}
