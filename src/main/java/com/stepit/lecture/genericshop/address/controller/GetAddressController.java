package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Log4j2
@Controller
@RequiredArgsConstructor
public class GetAddressController {

    private final AddressService addressService;

    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.address.getAddress}")
    public ModelAndView getAddresses(@RequestParam Integer id) {

        AddressDto address = addressService.getAddress(id);

        HashMap<String, AddressDto> model = new HashMap<>();
        model.put("address", address);

        return new ModelAndView("addresses", model, HttpStatus.OK);
    }

}
