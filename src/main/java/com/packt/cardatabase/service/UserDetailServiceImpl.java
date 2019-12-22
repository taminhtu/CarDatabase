/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.cardatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;


/**
 *
 * @author tutm
 */
@Configuration
@EnableWebSecurity
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User currentUser = repository.findByUserName(userName);
        UserDetails user = new org.springframework.security.core.userdetails.User(userName, currentUser.getPassword(), true, true, 
                true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
