package com.myriadessence.body.lab.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record BloodWorkResponse(
    UUID id,
    UUID userId,
    LocalDate collectedDate,
    String notes,
    List<BloodMarkerResponse> markers
) {}
