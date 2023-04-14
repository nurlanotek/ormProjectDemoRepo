package org.uca.sas.cs.course1.lesson5.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.uca.sas.cs.course1.lesson5.mapper.UserMapper;
import org.uca.sas.cs.course1.lesson5.model.User;

import java.util.ArrayDeque;

@Service
public class AuthenticationService implements AuthenticationProvider {
    private UserMapper userMapper;
    private HashService hashService;

    public AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMapper.getUser(username);
        if (user != null) {
            String encodeSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodeSalt);
            if (user.getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayDeque<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
