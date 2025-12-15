package com.myriadessence.body.lab.dto;

import com.myriadessence.body.lab.enums.BloodMarkerName;

public record BloodMarkerRequest(
    BloodMarkerName name,
    Double value,
    String unit
) {}
