package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Rent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-10T17:01:27+0300",
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

        return rent;
    }

    @Override
    public RentDTO toDTO(Rent entity) {
        if ( entity == null ) {
            return null;
        }

        RentDTO rentDTO = new RentDTO();

        rentDTO.setId( entity.getId() );

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
