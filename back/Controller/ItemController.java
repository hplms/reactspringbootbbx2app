package com.example.practicaBBX2.Controller;

import com.example.practicaBBX2.Model.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> findAllItems(){
        return itemService.findAll();
    }

    @PostMapping
    public ItemDTO saveItem(@RequestBody ItemDTO itemDTO){ return itemService.save(itemDTO); }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable(value = "id") long id, @RequestBody ItemDTO itemDTO) {
        return itemService.update(id,itemDTO);
    }

    @GetMapping("/creator{id}")
    public String getCreator(@PathVariable(value = "id") long id){
        return itemService.getCreator(id);
    }

}
