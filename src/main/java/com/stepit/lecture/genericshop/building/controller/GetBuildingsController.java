package com.stepit.lecture.genericshop.building.controller;


import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class GetBuildingsController {

    private final BuildingService buildingService;

    @GetMapping("${app.api.path.building.getBuildings}")
    public ModelAndView getAllBuildings() {
        log.info("Buildings controller");

        List<BuildingDto> allBuildings = buildingService.getAllBuildings();

        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info(allBuildings);
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Map<String, List<BuildingDto>> result = new HashMap<>();
        result.put("buildings", allBuildings);

        return new ModelAndView("buildings", result, HttpStatus.OK);
    }

}
