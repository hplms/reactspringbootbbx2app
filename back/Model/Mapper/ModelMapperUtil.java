package com.example.practicaBBX2.Model.Mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperUtil <T,H> {

    ModelMapper modelMapper = new ModelMapper();

    public H convertToDto (T entity);

    public T convertToEntity (H DTO);

}
