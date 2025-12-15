package com.myriadessence.body.lab.dto;

import com.myriadessence.body.lab.enums.BiometricType;
import java.time.Instant;
import java.util.UUID;

public record BiometricReadingResponse(
    UUID id,
    UUID userId,
    Instant measuredAt,
    BiometricType type,
    Double value1,
    Double value2,
    String source
) {}
