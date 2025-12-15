package com.myriadessence.body.lab.controller;

import com.myriadessence.body.lab.dto.BloodWorkRequest;
import com.myriadessence.body.lab.dto.BloodWorkResponse;
import com.myriadessence.body.lab.service.BloodWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lab/blood-work")
@RequiredArgsConstructor
public class BloodWorkController {

    private final BloodWorkService service;

    @GetMapping
    public List<BloodWorkResponse> getAllBloodWorks(@AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.getAllBloodWorks(userId);
    }

    @GetMapping("/{id}")
    public BloodWorkResponse getBloodWork(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.getBloodWork(userId, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BloodWorkResponse createBloodWork(@AuthenticationPrincipal Jwt jwt, @RequestBody BloodWorkRequest request) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.createBloodWork(userId, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBloodWork(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id) {
        UUID userId = UUID.fromString(jwt.getSubject());
        service.deleteBloodWork(userId, id);
    }
}
