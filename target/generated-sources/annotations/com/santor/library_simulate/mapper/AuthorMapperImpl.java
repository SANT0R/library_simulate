package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-10T21:40:16+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( dto.getId() );
        author.setFullName( dto.getFullName() );
        Set<Book> set = dto.getBooks();
        if ( set != null ) {
            author.setBooks( new HashSet<Book>( set ) );
        }

        return author;
    }

    @Override
    public AuthorDTO toDTO(Author entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( entity.getId() );
        authorDTO.setFullName( entity.getFullName() );
        Set<Book> set = entity.getBooks();
        if ( set != null ) {
            authorDTO.setBooks( new HashSet<Book>( set ) );
        }

        return authorDTO;
    }

    @Override
    public List<Author> toEntityList(List<AuthorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Author> list = new ArrayList<Author>( dtoList.size() );
        for ( AuthorDTO authorDTO : dtoList ) {
            list.add( toEntity( authorDTO ) );
        }

        return list;
    }

    @Override
    public List<AuthorDTO> toDTOList(List<Author> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AuthorDTO> list = new ArrayList<AuthorDTO>( entityList.size() );
        for ( Author author : entityList ) {
            list.add( toDTO( author ) );
        }

        return list;
    }
}
