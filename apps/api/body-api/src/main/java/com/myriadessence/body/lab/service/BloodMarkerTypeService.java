package com.myriadessence.body.lab.service;

import com.myriadessence.body.lab.dto.BloodMarkerTypeResponse;
import com.myriadessence.body.lab.entity.BloodMarkerType;
import com.myriadessence.body.lab.repository.BloodMarkerTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodMarkerTypeService {

    private final BloodMarkerTypeRepository markerTypeRepository;

    @Transactional(readOnly = true)
    public List<BloodMarkerTypeResponse> getAllMarkerTypes() {
        return markerTypeRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    private BloodMarkerTypeResponse mapToResponse(BloodMarkerType entity) {
        return new BloodMarkerTypeResponse(
                entity.getName(),
                entity.getDescription(),
                entity.getRecommendedUnit()
        );
    }
}
