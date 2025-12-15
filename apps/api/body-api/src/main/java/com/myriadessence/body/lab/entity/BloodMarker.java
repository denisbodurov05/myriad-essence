package com.myriadessence.body.lab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import com.myriadessence.body.lab.enums.BloodMarkerName;
import com.myriadessence.body.lab.enums.MarkerFlag;

@Entity
@Table(name = "blood_marker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "blood_work_id")
    private BloodWork bloodWork;

    @Enumerated(EnumType.STRING)
    private BloodMarkerName name;
    private Double value;
    private String unit;
    private String referenceRange;

    @Enumerated(EnumType.STRING)
    private MarkerFlag flag;
}
