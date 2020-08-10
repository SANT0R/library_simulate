package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-10T21:40:16+0300",
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
        rent.setStart_date( dto.getStart_date() );
        rent.setFinishDate( dto.getFinishDate() );
        rent.setReturnDate( dto.getReturnDate() );
        List<Book> list = dto.getBooks();
        if ( list != null ) {
            rent.setBooks( new ArrayList<Book>( list ) );
        }
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
        rentDTO.setStart_date( entity.getStart_date() );
        rentDTO.setFinishDate( entity.getFinishDate() );
        rentDTO.setReturnDate( entity.getReturnDate() );
        List<Book> list = entity.getBooks();
        if ( list != null ) {
            rentDTO.setBooks( new ArrayList<Book>( list ) );
        }
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
}
