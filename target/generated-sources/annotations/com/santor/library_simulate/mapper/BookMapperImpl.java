package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-10T17:01:27+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( dto.getId() );
        book.setName( dto.getName() );

        return book;
    }

    @Override
    public BookDTO toDTO(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( entity.getId() );
        bookDTO.setName( entity.getName() );

        return bookDTO;
    }

    @Override
    public List<Book> toEntityList(List<BookDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( dtoList.size() );
        for ( BookDTO bookDTO : dtoList ) {
            list.add( toEntity( bookDTO ) );
        }

        return list;
    }

    @Override
    public List<BookDTO> toDTOList(List<Book> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( entityList.size() );
        for ( Book book : entityList ) {
            list.add( toDTO( book ) );
        }

        return list;
    }
}
