package com.stepit.lecture.genericshop.security.config;

import com.stepit.lecture.genericshop.user.entity.Role;
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

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${app.api.path.address.getAddresses}")
    private String PATH_ADDRESSES;

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
                //form -> form.loginPage("/api/v1/signin")
                .formLogin(withDefaults())
        ;
//                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
