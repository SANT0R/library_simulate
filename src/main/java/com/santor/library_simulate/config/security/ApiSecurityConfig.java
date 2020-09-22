package com.santor.library_simulate.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
//                .antMatchers("/author/**","/book/**","/client/**","/rent/**").hasRole(ADMIN.name())
//                .antMatchers(HttpMethod.GET,"/author/**","/book/**").hasRole(CLIENT.name())
//                .antMatchers("/client/update","/client/delete","/client/getById",
//                            "/rent/add","/rent/update","/rent/getById").hasRole(CLIENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

}
