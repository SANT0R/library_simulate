package com.santor.library_simulate.service;


import com.santor.library_simulate.config.MyUserPrincipal;
import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.model.Client;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsServiceImpl implements UserDetailsService {

    private ClientRepository clientRepository;

    public UserPrincipalDetailsServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Client user = clientRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new MyUserPrincipal(user);
    }


}
