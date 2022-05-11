package com.example.practicaBBX2.Model.Service;
import com.example.practicaBBX2.Model.Mapper.ModelMapperUtilSupplier;
import com.example.practicaBBX2.Model.Repository.SupplierRepository;
import com.example.practicaBBX2.Controller.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService implements ServiceI<SupplierDTO> {

    @Autowired
    private SupplierRepository supplierRepository;

    ModelMapperUtilSupplier mmsupplier = new ModelMapperUtilSupplier();

    public List<SupplierDTO> findAll(){
        return supplierRepository.findAll().stream()
                .map(mmsupplier::convertToDto)
                .collect(Collectors.toList());
    }

    public SupplierDTO save(SupplierDTO supplierDTO){
        return mmsupplier.convertToDto(supplierRepository.save(mmsupplier.convertToEntity(supplierDTO)));
    }

    public ResponseEntity<SupplierDTO> update (long id, SupplierDTO supplierDTO) {
        if (supplierRepository.findById(id).isPresent()) {
            SupplierDTO supplierToUpdate = mmsupplier.convertToDto(supplierRepository.getById(supplierDTO.getSupplierid()));
            if(supplierDTO.getName()!=null)supplierToUpdate.setName(supplierDTO.getName());
            if(supplierDTO.getCountry()!=null)supplierToUpdate.setCountry(supplierDTO.getCountry());
            if(supplierDTO.getItem_id()!=null)supplierToUpdate.setItem_id(supplierDTO.getItem_id());
            return ResponseEntity.ok(this.save(supplierToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

}
