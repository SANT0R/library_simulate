package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.model.Rent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-11T15:40:11+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( dto.getId() );
        client.setClientName( dto.getClientName() );
        client.setPassword( dto.getPassword() );
        client.setEnabled( dto.isEnabled() );
        Set<Rent> set = dto.getRents();
        if ( set != null ) {
            client.setRents( new HashSet<Rent>( set ) );
        }

        return client;
    }

    @Override
    public ClientDTO toDTO(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( entity.getId() );
        clientDTO.setClientName( entity.getClientName() );
        clientDTO.setPassword( entity.getPassword() );
        clientDTO.setEnabled( entity.isEnabled() );
        Set<Rent> set = entity.getRents();
        if ( set != null ) {
            clientDTO.setRents( new HashSet<Rent>( set ) );
        }

        return clientDTO;
    }

    @Override
    public List<Client> toEntityList(List<ClientDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ClientDTO clientDTO : dtoList ) {
            list.add( toEntity( clientDTO ) );
        }

        return list;
    }

    @Override
    public List<ClientDTO> toDTOList(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDTO( client ) );
        }

        return list;
    }
}
