package com.stepit.lecture.genericshop.address.service;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.bff.feign.client.GenericShopApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final GenericShopApiClient genericShopApiClient;

    public AddressDto getAddress(Integer id) {
        return genericShopApiClient.getAddress(id);
    }

}
