package com.stepit.lecture.genericshop.security.config;

import com.stepit.lecture.genericshop.security.filter.SingInRequestFilter;
import com.stepit.lecture.genericshop.security.handler.SignInSuccessfulHandler;
import com.stepit.lecture.genericshop.user.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${app.api.path.address.getAddresses}")
    private String PATH_ADDRESSES;

    private final SignInSuccessfulHandler signInSuccessfulHandler;

    private final SingInRequestFilter singInRequestFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/buildings")
                        .authenticated()

                        .requestMatchers(PATH_ADDRESSES)
                        .hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())

                        .requestMatchers( "/building")
                        .hasAuthority(Role.ADMIN.toString())

                        .requestMatchers(HttpMethod.DELETE)
                        .hasAuthority(Role.ADMIN.toString())

                        .anyRequest()
                        .permitAll()
                )
                .formLogin(login -> login
                        .loginPage("/signin")
                        .successHandler(signInSuccessfulHandler)
                )
                .addFilterBefore(singInRequestFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
