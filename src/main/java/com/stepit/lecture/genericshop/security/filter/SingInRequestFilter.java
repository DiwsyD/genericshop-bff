package com.stepit.lecture.genericshop.security.filter;

import com.google.gson.Gson;
import com.stepit.lecture.genericshop.security.entity.CustomUserDetails;
import com.stepit.lecture.genericshop.security.service.CookieService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
@Component
@RequiredArgsConstructor
public class SingInRequestFilter extends OncePerRequestFilter {

    @Value("${security.app.authentication.cookie}")
    private String USER_CREDENTIALS_COOKIE;

    private final CookieService cookieService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jsonPrincipal = cookieService.getCookie(USER_CREDENTIALS_COOKIE, request);
        if (jsonPrincipal != null) {
            CustomUserDetails customUserDetails = new Gson().fromJson(jsonPrincipal, CustomUserDetails.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    customUserDetails,
                    null,
                    customUserDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}
