package com.myriadessence.body.lab.dto;

import com.myriadessence.body.lab.enums.Severity;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record SicknessRecordResponse(
    UUID id,
    UUID userId,
    LocalDate startDate,
    LocalDate endDate,
    Set<String> symptoms,
    String diagnosis,
    Severity severity
) {}
