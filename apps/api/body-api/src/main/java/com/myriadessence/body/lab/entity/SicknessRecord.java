package com.myriadessence.body.lab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import com.myriadessence.body.lab.enums.Severity;

@Entity
@Table(name = "sickness_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SicknessRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private LocalDate startDate;
    private LocalDate endDate;

    private String symptoms;
    private String diagnosis;

    @Enumerated(EnumType.STRING)
    private Severity severity;
}
