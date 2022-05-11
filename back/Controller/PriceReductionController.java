package com.example.practicaBBX2.Controller;

import com.example.practicaBBX2.Model.Service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pricereductions")
public class PriceReductionController {
    @Autowired
    private PriceReductionService priceReductionService;

    @GetMapping
    public List<PriceReductionDTO> findAllPriceReductions(){
        return priceReductionService.findAll();
    }

    @PostMapping
    public PriceReductionDTO savePriceReduction(@RequestBody PriceReductionDTO priceReductionDTO){ return priceReductionService.save(priceReductionDTO); }

    @PutMapping("/{id}")
    public ResponseEntity<PriceReductionDTO> updatePriceReduction (@PathVariable(value = "id") long id, @RequestBody PriceReductionDTO priceReductionDTO) {
        return priceReductionService.update(id,priceReductionDTO);
    }
}
