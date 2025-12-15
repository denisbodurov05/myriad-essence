package com.myriadessence.body.lab.repository;

import com.myriadessence.body.lab.entity.BloodMarker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BloodMarkerRepository extends JpaRepository<BloodMarker, UUID> {
    List<BloodMarker> findAllByBloodWorkId(UUID bloodWorkId);
}
