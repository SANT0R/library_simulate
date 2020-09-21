package com.santor.library_simulate.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.santor.library_simulate.config.security.ApiUserRole.ADMIN;
import static com.santor.library_simulate.config.security.ApiUserRole.CLIENT;


@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApiSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*","/client/add").permitAll()
                .antMatchers("/author/**","/book/**","/client/**","/rent/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET,"/author/**","/book/**").hasRole(CLIENT.name())
                .antMatchers("/client/update","/client/delete","/client/getById",
                            "/rent/add","/rent/update","/rent/getById").hasRole(CLIENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

}
