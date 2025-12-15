package com.myriadessence.body.lab.dto;

import com.myriadessence.body.lab.enums.BiometricType;
import java.time.Instant;

public record BiometricReadingRequest(
    Instant measuredAt,
    BiometricType type,
    Double value1,
    Double value2,
    String source
) {}
