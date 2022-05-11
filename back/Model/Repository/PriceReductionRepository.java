package com.example.practicaBBX2.Model.Repository;

import com.example.practicaBBX2.Model.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceReductionRepository extends JpaRepository <PriceReduction,Long> {}
