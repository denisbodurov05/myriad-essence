package com.myriadessence.body.vitality.dto;

import com.myriadessence.body.vitality.enums.BiometricType;
import java.time.Instant;

public record BiometricReadingRequest(
    Instant measuredAt,
    BiometricType type,
    Double value1,
    Double value2,
    String source
) {}
