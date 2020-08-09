package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Named("toEntity")
    Client toEntity(ClientDTO dto);

    @Named("toDTO")
    ClientDTO toDTO(Client entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Client> toEntityList(List<ClientDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<ClientDTO> toDTOList(List<Client> entityList);

}
