package com.myriadessence.body.lab.service;

import com.myriadessence.body.lab.dto.SicknessRecordRequest;
import com.myriadessence.body.lab.dto.SicknessRecordResponse;
import com.myriadessence.body.lab.entity.SicknessRecord;
import com.myriadessence.body.exception.ResourceNotFoundException;
import com.myriadessence.body.lab.repository.SicknessRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SicknessRecordService {

    private final SicknessRecordRepository repository;

    @Transactional(readOnly = true)
    public List<SicknessRecordResponse> getAllRecords(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional
    public SicknessRecordResponse createRecord(UUID userId, SicknessRecordRequest request) {
        SicknessRecord entity = new SicknessRecord();
        entity.setUserId(userId);
        entity.setStartDate(request.startDate());
        entity.setEndDate(request.endDate());
        entity.setSymptoms(joinSymptoms(request.symptoms()));
        entity.setDiagnosis(request.diagnosis());
        entity.setSeverity(request.severity());

        SicknessRecord saved = repository.save(entity);
        return mapToResponse(saved);
    }


    @Transactional
    public SicknessRecordResponse updateRecord(UUID userId, UUID id, SicknessRecordRequest request) {
        return repository.findById(id)
                .filter(record -> record.getUserId().equals(userId))
                .map(entity -> {
                    entity.setStartDate(request.startDate());
                    entity.setEndDate(request.endDate());
                    entity.setSymptoms(joinSymptoms(request.symptoms()));
                    entity.setDiagnosis(request.diagnosis());
                    entity.setSeverity(request.severity());
                    return mapToResponse(repository.save(entity));
                })
                .orElseThrow(() -> new ResourceNotFoundException("SicknessRecord not found with id: " + id));
    }

    @Transactional
    public void deleteRecord(UUID userId, UUID id) {
        repository.findById(id)
                .filter(record -> record.getUserId().equals(userId))
                .ifPresent(repository::delete);
    }

    private SicknessRecordResponse mapToResponse(SicknessRecord entity) {
        return new SicknessRecordResponse(
                entity.getId(),
                entity.getUserId(),
                entity.getStartDate(),
                entity.getEndDate(),
                parseSymptoms(entity.getSymptoms()),
                entity.getDiagnosis(),
                entity.getSeverity()
        );
    }

    private String joinSymptoms(Set<String> symptoms) {
        if (symptoms == null || symptoms.isEmpty()) {
            return null;
        }
        return String.join(",", symptoms);
    }

    private Set<String> parseSymptoms(String symptomsString) {
        if (symptomsString == null || symptomsString.isEmpty()) {
            return Collections.emptySet();
        }
        return Arrays.stream(symptomsString.split(","))
                .collect(Collectors.toSet());
    }
}
