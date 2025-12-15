package com.myriadessence.body.lab.service;

import com.myriadessence.body.lab.dto.BiometricReadingRequest;
import com.myriadessence.body.lab.dto.BiometricReadingResponse;
import com.myriadessence.body.lab.entity.BiometricReading;
import com.myriadessence.body.lab.repository.BiometricReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BiometricReadingService {

    private final BiometricReadingRepository repository;

    @Transactional(readOnly = true)
    public List<BiometricReadingResponse> getAllReadings(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional
    public BiometricReadingResponse createReading(UUID userId, BiometricReadingRequest request) {
        BiometricReading entity = new BiometricReading();
        entity.setUserId(userId);
        entity.setMeasuredAt(request.measuredAt());
        entity.setType(request.type());
        entity.setValue1(request.value1());
        entity.setValue2(request.value2());
        entity.setSource(request.source());

        BiometricReading saved = repository.save(entity);
        return mapToResponse(saved);
    }

    @Transactional
    public void deleteReading(UUID userId, UUID id) {
        // Ensure the reading belongs to the user before deleting
        repository.findById(id)
                .filter(reading -> reading.getUserId().equals(userId))
                .ifPresent(repository::delete);
    }

    private BiometricReadingResponse mapToResponse(BiometricReading entity) {
        return new BiometricReadingResponse(
                entity.getId(),
                entity.getUserId(),
                entity.getMeasuredAt(),
                entity.getType(),
                entity.getValue1(),
                entity.getValue2(),
                entity.getSource()
        );
    }
}
