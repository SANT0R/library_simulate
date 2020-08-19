package com.santor.library_simulate.mapper;


import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Rent;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface RentMapper {


    @Named("toEntity")
    Rent toEntity(RentDTO dto);

    @Named("toDTO")
    RentDTO toDTO(Rent entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Rent> toEntityList(List<RentDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<RentDTO> toDTOList(List<Rent> entityList);

}
