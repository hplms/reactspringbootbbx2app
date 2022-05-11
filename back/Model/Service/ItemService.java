package com.example.practicaBBX2.Model.Service;
import com.example.practicaBBX2.Controller.ItemDTO;
import com.example.practicaBBX2.Model.Mapper.ModelMapperUtilItem;
import com.example.practicaBBX2.Model.Repository.ItemRepository;
import com.example.practicaBBX2.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService implements ServiceI <ItemDTO> {

    @Autowired
    private ItemRepository itemRepository;

    ModelMapperUtilItem mmitem = new ModelMapperUtilItem();

    public List<ItemDTO> findAll(){
        return itemRepository.findAll().stream()
                .map(mmitem::convertToDto)
                .collect(Collectors.toList());
    }

    public ItemDTO save(ItemDTO itemDTO){
        return mmitem.convertToDto(itemRepository.save(mmitem.convertToEntity(itemDTO)));
    }

    public ResponseEntity<ItemDTO> update (long id, ItemDTO itemDTO) {
        if (itemRepository.findById(id).isPresent()) {
            ItemDTO itemToUpdate = mmitem.convertToDto(itemRepository.getById(itemDTO.getItemid()));
            if(itemDTO.getDescription()!=null)itemToUpdate.setDescription(itemDTO.getDescription());
            if(itemDTO.getState()!=null)itemToUpdate.setState(itemDTO.getState());
            if(itemDTO.getPrice()!=null) itemToUpdate.setPrice(itemDTO.getPrice());
            if(itemDTO.getCreationDate()!=null) itemToUpdate.setCreationDate(itemDTO.getCreationDate());
            if(itemDTO.getCreator()!=null)itemToUpdate.setCreator(itemDTO.getCreator());
            return ResponseEntity.ok(this.save(itemToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    public String getCreator (long id){
        User creator = itemRepository.getById(id).getCreator();
        if(creator != null) return creator.getUsername();
        else return "";
    }


}
