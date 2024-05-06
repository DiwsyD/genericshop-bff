package com.stepit.lecture.genericshop.building.service;

import com.stepit.lecture.genericshop.bff.feign.GenericShopApiClient;
import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuildingService {

    private final GenericShopApiClient genericShopApiClient;

    public List<BuildingDto> getAllBuildings() {
        return genericShopApiClient.getBuildings();
    }

}
