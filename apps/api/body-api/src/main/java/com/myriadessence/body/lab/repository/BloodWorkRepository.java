package com.myriadessence.body.lab.repository;

import com.myriadessence.body.lab.entity.BloodWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BloodWorkRepository extends JpaRepository<BloodWork, UUID> {
    List<BloodWork> findAllByUserId(UUID userId);
}
