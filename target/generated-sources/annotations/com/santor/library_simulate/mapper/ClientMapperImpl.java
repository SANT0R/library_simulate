package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-24T21:02:54+0300",
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
        client.setUserName( dto.getUserName() );
        client.setFullName( dto.getFullName() );
        client.setPassword( dto.getPassword() );
        client.setPhone( dto.getPhone() );
        client.setEMail( dto.getEMail() );

        return client;
    }

    @Override
    public ClientDTO toDTO(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( entity.getId() );
        clientDTO.setUserName( entity.getUserName() );
        clientDTO.setFullName( entity.getFullName() );
        clientDTO.setPassword( entity.getPassword() );
        clientDTO.setPhone( entity.getPhone() );
        clientDTO.setEMail( entity.getEMail() );

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
