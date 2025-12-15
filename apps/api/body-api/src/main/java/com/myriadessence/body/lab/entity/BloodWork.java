package com.myriadessence.body.lab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "blood_work")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodWork {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private LocalDate collectedDate;
    private String notes;

    @OneToMany(mappedBy = "bloodWork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BloodMarker> markers;
}
