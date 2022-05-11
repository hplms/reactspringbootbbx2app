package com.example.practicaBBX2.Model.Service;
import com.example.practicaBBX2.Model.Mapper.ModelMapperUtilUser;
import com.example.practicaBBX2.Model.Repository.UserRepository;
import com.example.practicaBBX2.Controller.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements ServiceI <UserDTO> {

    @Autowired
    private UserRepository userRepository;

    ModelMapperUtilUser mmuser = new ModelMapperUtilUser();


    public List<UserDTO> findAll(){
        return userRepository.findAll().stream()
                .map(mmuser::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO userDTO){
        return mmuser.convertToDto(userRepository.save(mmuser.convertToEntity(userDTO)));
    }

    public ResponseEntity<UserDTO> update(long id, UserDTO userDTO) {
        if (userRepository.findById(id).isPresent()) {
            UserDTO userToUpdate = mmuser.convertToDto(userRepository.getById(userDTO.getUserid()));
            if(userDTO.getFirstName()!=null)userToUpdate.setFirstName(userDTO.getFirstName());
            if(userDTO.getSecondName()!=null)userToUpdate.setSecondName(userDTO.getSecondName());
            if(userDTO.getUsername()!=null)userToUpdate.setUsername(userDTO.getUsername());
            if(userDTO.getPassword()!=null)userToUpdate.setPassword(userDTO.getPassword());
            if(userDTO.getItem_id()!=null)userToUpdate.setItem_id(userDTO.getItem_id());

            return ResponseEntity.ok(this.save(userToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

}