package com.example.practicaBBX2.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;
    private String firstName;
    private String secondName;
    @OneToMany(mappedBy = "creator",cascade=CascadeType.ALL)
    private Set<Item> items;

    private String username;
    private String password;

    public Long getUserid() { return userid; }

    public void setUserid(Long userid) { this.userid = userid; }

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

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Set<Item> getItems() { return items; }

    public void setItems(Set<Item> items) { this.items = items; }
}
