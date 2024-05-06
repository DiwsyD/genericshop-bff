package com.stepit.lecture.genericshop.building.dto;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingDto {

    private Integer id;
    private Double price;
    private Double square;
    private AddressDto full_address;

}
