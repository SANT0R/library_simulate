package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-24T21:02:54+0300",
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
        book.setFullName( dto.getFullName() );
        book.setPublisher( dto.getPublisher() );
        book.setReleaseYear( dto.getReleaseYear() );
        book.setType( dto.getType() );
        book.setDescription( dto.getDescription() );
        book.setPage( dto.getPage() );
        book.setStock( dto.getStock() );
        book.setAuthor( authorDTOToAuthor( dto.getAuthor() ) );

        return book;
    }

    @Override
    public BookDTO toDTO(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( entity.getId() );
        bookDTO.setFullName( entity.getFullName() );
        bookDTO.setPublisher( entity.getPublisher() );
        bookDTO.setReleaseYear( entity.getReleaseYear() );
        bookDTO.setType( entity.getType() );
        bookDTO.setDescription( entity.getDescription() );
        bookDTO.setPage( entity.getPage() );
        bookDTO.setStock( entity.getStock() );
        bookDTO.setAuthor( authorToAuthorDTO( entity.getAuthor() ) );

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

    protected Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setFullName( authorDTO.getFullName() );

        return author;
    }

    protected AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setFullName( author.getFullName() );

        return authorDTO;
    }
}
