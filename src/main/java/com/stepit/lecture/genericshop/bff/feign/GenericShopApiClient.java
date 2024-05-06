package com.stepit.lecture.genericshop.bff.feign;

import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("GENERICSHOP")
public interface GenericShopApiClient {

    @GetMapping("${app.api.version.genericshop}${app.api.path.building.getBuildings}")
    List<BuildingDto> getBuildings();

    @GetMapping("${app.api.version.genericshop}${app.api.path.user.getUser}")
    User getUserByEmail(@RequestParam String email);

}
