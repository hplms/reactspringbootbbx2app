package com.example.practicaBBX2.Model.Mapper;

import com.example.practicaBBX2.Model.Supplier;
import com.example.practicaBBX2.Controller.SupplierDTO;

public class ModelMapperUtilSupplier implements ModelMapperUtil <Supplier, SupplierDTO> {

    public SupplierDTO convertToDto (Supplier supplier){
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public Supplier convertToEntity (SupplierDTO supplierDTO){
        return modelMapper.map(supplierDTO, Supplier.class);
    }

}
