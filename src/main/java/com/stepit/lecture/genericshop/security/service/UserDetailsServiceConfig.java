package com.stepit.lecture.genericshop.security.service;

import com.stepit.lecture.genericshop.exception.UserNotFoundException;
import com.stepit.lecture.genericshop.security.entity.CustomUserDetails;
import com.stepit.lecture.genericshop.user.entity.Role;
import com.stepit.lecture.genericshop.user.entity.User;
import com.stepit.lecture.genericshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserDetailsServiceConfig implements UserDetailsService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUser(username);
        log.info("GOT User: " + user);
        if (user.getRole().equals(Role.UNKNOWN)) {
            throw new UserNotFoundException(String.format("Wrong username - [%s]", username));
        }
        return CustomUserDetails.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(mapRolesToGrantedAuthorities(user.getRole()))
                .build();
    }

    private Collection<GrantedAuthority> mapRolesToGrantedAuthorities(Role role) {
        return Stream.of(role)
                .map(r -> new SimpleGrantedAuthority(r.toString()))
                .collect(Collectors.toList());
    }

}
