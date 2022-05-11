package com.example.practicaBBX2.Model.Mapper;

import com.example.practicaBBX2.Model.User;
import com.example.practicaBBX2.Controller.UserDTO;

public class ModelMapperUtilUser implements ModelMapperUtil <User, UserDTO> {

    public UserDTO convertToDto (User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity (UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

}
