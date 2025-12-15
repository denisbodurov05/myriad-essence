package com.myriadessence.body.vitality.controller;

import com.myriadessence.body.vitality.dto.BiometricReadingRequest;
import com.myriadessence.body.vitality.dto.BiometricReadingResponse;
import com.myriadessence.body.vitality.service.BiometricReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vitality/biometrics")
@RequiredArgsConstructor
public class BiometricReadingController {

    private final BiometricReadingService service;

    @GetMapping
    public List<BiometricReadingResponse> getAllReadings(@AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.getAllReadings(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BiometricReadingResponse createReading(@AuthenticationPrincipal Jwt jwt, @RequestBody BiometricReadingRequest request) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.createReading(userId, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReading(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id) {
        UUID userId = UUID.fromString(jwt.getSubject());
        service.deleteReading(userId, id);
    }
}
