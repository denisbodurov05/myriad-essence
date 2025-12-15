package com.myriadessence.body.lab.controller;

import com.myriadessence.body.lab.dto.SicknessRecordRequest;
import com.myriadessence.body.lab.dto.SicknessRecordResponse;
import com.myriadessence.body.lab.service.SicknessRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lab/sickness")
@RequiredArgsConstructor
public class SicknessRecordController {

    private final SicknessRecordService service;

    @GetMapping
    public List<SicknessRecordResponse> getAllRecords(@AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.getAllRecords(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SicknessRecordResponse createRecord(@AuthenticationPrincipal Jwt jwt, @RequestBody SicknessRecordRequest request) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.createRecord(userId, request);
    }

    @PutMapping("/{id}")
    public SicknessRecordResponse updateRecord(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id, @RequestBody SicknessRecordRequest request) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.updateRecord(userId, id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecord(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id) {
        UUID userId = UUID.fromString(jwt.getSubject());
        service.deleteRecord(userId, id);
    }
}
