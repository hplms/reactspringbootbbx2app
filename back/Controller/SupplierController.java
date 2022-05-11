package com.example.practicaBBX2.Controller;

import com.example.practicaBBX2.Model.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<SupplierDTO> findAllSuppliers(){
        return supplierService.findAll();
    }

    @PostMapping
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){ return supplierService.save(supplierDTO); }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateItem (@PathVariable(value = "id") long id, @RequestBody SupplierDTO supplierDTO) {
        return supplierService.update(id,supplierDTO);
    }
}
