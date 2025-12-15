package com.myriadessence.body.lab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blood_marker_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodMarkerType {

    @Id
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "recommended_unit")
    private String recommendedUnit;
}
