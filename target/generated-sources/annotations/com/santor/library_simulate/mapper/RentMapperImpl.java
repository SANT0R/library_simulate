package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-24T21:02:54+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class RentMapperImpl implements RentMapper {

    @Override
    public Rent toEntity(RentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rent rent = new Rent();

        rent.setId( dto.getId() );
        rent.setStartDate( dto.getStartDate() );
        rent.setFinishDate( dto.getFinishDate() );
        rent.setReturnDate( dto.getReturnDate() );
        rent.setBooks( bookDTOSetToBookSet( dto.getBooks() ) );
        rent.setClient( dto.getClient() );

        return rent;
    }

    @Override
    public RentDTO toDTO(Rent entity) {
        if ( entity == null ) {
            return null;
        }

        RentDTO rentDTO = new RentDTO();

        rentDTO.setId( entity.getId() );
        rentDTO.setStartDate( entity.getStartDate() );
        rentDTO.setFinishDate( entity.getFinishDate() );
        rentDTO.setReturnDate( entity.getReturnDate() );
        rentDTO.setBooks( bookSetToBookDTOSet( entity.getBooks() ) );
        rentDTO.setClient( entity.getClient() );

        return rentDTO;
    }

    @Override
    public List<Rent> toEntityList(List<RentDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Rent> list = new ArrayList<Rent>( dtoList.size() );
        for ( RentDTO rentDTO : dtoList ) {
            list.add( toEntity( rentDTO ) );
        }

        return list;
    }

    @Override
    public List<RentDTO> toDTOList(List<Rent> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RentDTO> list = new ArrayList<RentDTO>( entityList.size() );
        for ( Rent rent : entityList ) {
            list.add( toDTO( rent ) );
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

    protected Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setFullName( bookDTO.getFullName() );
        book.setPublisher( bookDTO.getPublisher() );
        book.setReleaseYear( bookDTO.getReleaseYear() );
        book.setType( bookDTO.getType() );
        book.setDescription( bookDTO.getDescription() );
        book.setPage( bookDTO.getPage() );
        book.setStock( bookDTO.getStock() );
        book.setAuthor( authorDTOToAuthor( bookDTO.getAuthor() ) );

        return book;
    }

    protected Set<Book> bookDTOSetToBookSet(Set<BookDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Book> set1 = new HashSet<Book>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BookDTO bookDTO : set ) {
            set1.add( bookDTOToBook( bookDTO ) );
        }

        return set1;
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

    protected BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setFullName( book.getFullName() );
        bookDTO.setPublisher( book.getPublisher() );
        bookDTO.setReleaseYear( book.getReleaseYear() );
        bookDTO.setType( book.getType() );
        bookDTO.setDescription( book.getDescription() );
        bookDTO.setPage( book.getPage() );
        bookDTO.setStock( book.getStock() );
        bookDTO.setAuthor( authorToAuthorDTO( book.getAuthor() ) );

        return bookDTO;
    }

    protected Set<BookDTO> bookSetToBookDTOSet(Set<Book> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookDTO> set1 = new HashSet<BookDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Book book : set ) {
            set1.add( bookToBookDTO( book ) );
        }

        return set1;
    }
}
