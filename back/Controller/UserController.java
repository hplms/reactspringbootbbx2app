package com.example.practicaBBX2.Controller;

import com.example.practicaBBX2.Model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAllUsers(){
        return (List<UserDTO>) userService.findAll();
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateItem (@PathVariable(value = "id") long id, @RequestBody UserDTO userDTO) {
        return userService.update(id,userDTO);
    }
}
