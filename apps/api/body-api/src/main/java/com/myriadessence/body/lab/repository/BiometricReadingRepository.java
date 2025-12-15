package com.myriadessence.body.lab.repository;

import com.myriadessence.body.lab.entity.BiometricReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BiometricReadingRepository extends JpaRepository<BiometricReading, UUID> {
    List<BiometricReading> findAllByUserId(UUID userId);
}
