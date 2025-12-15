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

import java.time.Instant;
import java.util.UUID;

import com.myriadessence.body.lab.enums.BiometricType;

@Entity
@Table(name = "biometric_reading")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiometricReading {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private Instant measuredAt;

    @Enumerated(EnumType.STRING)
    private BiometricType type;

    private Double value1; // e.g., BPM, SpO2, Systolic BP
    private Double value2; // e.g., Diastolic BP (nullable)

    private String source;
}
