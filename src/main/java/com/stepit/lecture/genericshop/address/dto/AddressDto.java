package com.stepit.lecture.genericshop.address.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private Integer id;
    private String city;
    private String street;

}
