package com.example.practicaBBX2.Model.Service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceI<H>{

    public List<H> findAll();
    public H save(H DTO);
    public ResponseEntity<H> update (long id, H DTO);

}
