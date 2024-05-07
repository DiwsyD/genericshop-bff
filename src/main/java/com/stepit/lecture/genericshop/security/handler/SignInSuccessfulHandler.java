package com.stepit.lecture.genericshop.security.handler;

import com.google.gson.Gson;
import com.stepit.lecture.genericshop.security.entity.CustomUserDetails;
import com.stepit.lecture.genericshop.security.service.CookieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Log4j2
@Component
@RequiredArgsConstructor
public class SignInSuccessfulHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final CookieService cookieService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        String jsonPrincipal = new Gson().toJson(principal);
        cookieService.createCookie("user_data", jsonPrincipal, 24 * 60 * 60, response);
        response.sendRedirect("/");
    }
}
