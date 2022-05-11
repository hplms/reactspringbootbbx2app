package com.example.practicaBBX2.Model.Repository;

import com.example.practicaBBX2.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {}


