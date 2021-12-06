package com.test.config;


import com.test.exceptions.NotFoundException;
import com.test.model.Authority;
import com.test.model.Status;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.getByEmail(email);
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException("Wrong application email: " + email);
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Authority authority : user.getAuthorities()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
            if (user.getStatus().equals(Status.UNVERIFIED)) {
                return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                        true, true, true, false, grantedAuthorities);
            }
        }


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);



    }
}