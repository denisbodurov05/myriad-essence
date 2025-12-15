package com.myriadessence.body.lab.repository;

import com.myriadessence.body.lab.entity.SicknessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SicknessRecordRepository extends JpaRepository<SicknessRecord, UUID> {
    List<SicknessRecord> findAllByUserId(UUID userId);
}
