package com.myriadessence.body.lab.dto;

import com.myriadessence.body.lab.enums.BloodMarkerName;
import java.util.UUID;

public record BloodMarkerResponse(
    UUID id,
    BloodMarkerName name,
    Double value,
    String unit
) {}
