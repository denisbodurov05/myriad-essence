package com.myriadessence.body.lab.dto;

import com.myriadessence.body.lab.enums.Severity;
import java.time.LocalDate;
import java.util.Set;

public record SicknessRecordRequest(
    LocalDate startDate,
    LocalDate endDate,
    Set<String> symptoms,
    String diagnosis,
    Severity severity
) {}
