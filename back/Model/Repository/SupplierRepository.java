package com.example.practicaBBX2.Model.Repository;

import com.example.practicaBBX2.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier,Long> {
}
