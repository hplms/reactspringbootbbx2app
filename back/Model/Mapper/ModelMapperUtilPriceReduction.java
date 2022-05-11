package com.example.practicaBBX2.Model.Mapper;

import com.example.practicaBBX2.Model.PriceReduction;
import com.example.practicaBBX2.Controller.PriceReductionDTO;

public class ModelMapperUtilPriceReduction implements ModelMapperUtil <PriceReduction, PriceReductionDTO> {

    public PriceReductionDTO convertToDto (PriceReduction priceReduction){
        return modelMapper.map(priceReduction, PriceReductionDTO.class);
    }

    public PriceReduction convertToEntity (PriceReductionDTO priceReductionDTO){
        return modelMapper.map(priceReductionDTO, PriceReduction.class);
    }

}
