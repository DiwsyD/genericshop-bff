package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class GetAddressesController {

    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.address.getAddresses}")
    public ModelAndView getAddresses() {

        return new ModelAndView("addresses", new HashMap<>(), HttpStatus.OK);
    }

}
