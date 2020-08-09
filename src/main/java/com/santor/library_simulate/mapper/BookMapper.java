package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Book;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface BookMapper {

    @Named("toEntity")
    Book toEntity(BookDTO dto);

    @Named("toDTO")
    BookDTO toDTO(Book entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Book> toEntityList(List<BookDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<BookDTO> toDTOList(List<Book> entityList);

}
