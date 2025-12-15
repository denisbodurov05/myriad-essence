package com.myriadessence.body.lab.controller;

import com.myriadessence.body.lab.dto.BloodMarkerTypeResponse;
import com.myriadessence.body.lab.service.BloodMarkerTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lab/marker-types")
@RequiredArgsConstructor
public class BloodMarkerTypeController {

    private final BloodMarkerTypeService markerTypeService;

    @GetMapping
    public List<BloodMarkerTypeResponse> getAllMarkerTypes() {
        return markerTypeService.getAllMarkerTypes();
    }
}
