package com.santor.library_simulate.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


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
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/client/**","/rent/**").hasRole(ApiUserRole.CLIENT.name())
                .antMatchers("/author/**","/book/**","/client/**","/rent/**").hasRole(ApiUserRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails Admin = User.builder()
                .username("MehmetSantor")
                .password(passwordEncoder.encode("password"))
                .roles(ApiUserRole.ADMIN.name())
                .build();

        UserDetails Client = User.builder()
                .username("MehmetSantor")
                .password(passwordEncoder.encode("1234"))
                .roles(ApiUserRole.CLIENT.name())
                .build();

        return new InMemoryUserDetailsManager(
                Admin,Client
        );
    }
}
