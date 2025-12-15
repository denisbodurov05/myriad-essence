package com.myriadessence.body.lab.dto;

import java.time.LocalDate;
import java.util.List;

public record BloodWorkRequest(
    LocalDate collectedDate,
    String notes,
    List<BloodMarkerRequest> markers
) {}
