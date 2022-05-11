package com.example.practicaBBX2.Model.Mapper;

import com.example.practicaBBX2.Model.Item;
import com.example.practicaBBX2.Controller.ItemDTO;

public class ModelMapperUtilItem implements ModelMapperUtil <Item, ItemDTO> {

    public ItemDTO convertToDto (Item item){
        return modelMapper.map(item, ItemDTO.class);
    }

    public Item convertToEntity (ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }

}
