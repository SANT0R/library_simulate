package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Named("toEntity")
    Author toEntity(AuthorDTO dto);

    @Named("toDTO")
    AuthorDTO toDTO(Author entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Author> toEntityList(List<AuthorDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<AuthorDTO> toDTOList(List<Author> entityList);

}
