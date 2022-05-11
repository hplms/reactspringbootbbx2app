package com.example.practicaBBX2.Model.Service;
import com.example.practicaBBX2.Model.Mapper.ModelMapperUtilPriceReduction;
import com.example.practicaBBX2.Controller.PriceReductionDTO;
import com.example.practicaBBX2.Model.Repository.PriceReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceReductionService implements ServiceI <PriceReductionDTO> {

    @Autowired
    private PriceReductionRepository priceReductionRepository;

    ModelMapperUtilPriceReduction mmpricereduction = new ModelMapperUtilPriceReduction();

    public List<PriceReductionDTO> findAll(){
        return priceReductionRepository.findAll().stream()
                .map(mmpricereduction::convertToDto)
                .collect(Collectors.toList());
    }

    public PriceReductionDTO save(PriceReductionDTO priceReductionDTO){
        return mmpricereduction.convertToDto(priceReductionRepository.save(mmpricereduction.convertToEntity(priceReductionDTO)));
    }

    public ResponseEntity<PriceReductionDTO> update(long id, PriceReductionDTO priceReductionDTO) {
        if (priceReductionRepository.findById(id).isPresent()) {
            PriceReductionDTO supplierToUpdate = mmpricereduction.convertToDto(priceReductionRepository.getById(priceReductionDTO.getPricereductionid()));
            if(priceReductionDTO.getStartDate()!=null)supplierToUpdate.setStartDate(priceReductionDTO.getStartDate());
            if(priceReductionDTO.getEndDate()!=null)supplierToUpdate.setEndDate(priceReductionDTO.getEndDate());
            if(priceReductionDTO.getItem_id()!=null)supplierToUpdate.setItem_id(priceReductionDTO.getItem_id());
            return ResponseEntity.ok(this.save(supplierToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

}
