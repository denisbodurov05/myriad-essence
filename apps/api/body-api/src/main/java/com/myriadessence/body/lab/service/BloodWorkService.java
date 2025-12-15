package com.myriadessence.body.lab.service;

import com.myriadessence.body.lab.dto.BloodMarkerResponse;
import com.myriadessence.body.lab.dto.BloodWorkRequest;
import com.myriadessence.body.lab.dto.BloodWorkResponse;
import com.myriadessence.body.lab.entity.BloodMarker;
import com.myriadessence.body.lab.entity.BloodWork;
import com.myriadessence.body.lab.repository.BloodWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodWorkService {

    private final BloodWorkRepository repository;

    @Transactional(readOnly = true)
    public List<BloodWorkResponse> getAllBloodWorks(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public BloodWorkResponse getBloodWork(UUID userId, UUID id) {
        return repository.findById(id)
                .filter(bw -> bw.getUserId().equals(userId))
                .map(this::mapToResponse)
                .orElse(null); // Or throw exception
    }

    @Transactional
    public BloodWorkResponse createBloodWork(UUID userId, BloodWorkRequest request) {
        BloodWork bloodWork = new BloodWork();
        bloodWork.setUserId(userId);
        bloodWork.setCollectedDate(request.collectedDate());
        bloodWork.setNotes(request.notes());

        List<BloodMarker> markers = request.markers().stream()
                .map(dto -> {
                    BloodMarker marker = new BloodMarker();
                    marker.setName(dto.name());
                    marker.setValue(dto.value());
                    marker.setUnit(dto.unit());
                    marker.setBloodWork(bloodWork);
                    return marker;
                })
                .collect(Collectors.toList());

        bloodWork.setMarkers(markers);

        BloodWork saved = repository.save(bloodWork);
        return mapToResponse(saved);
    }

    @Transactional
    public void deleteBloodWork(UUID userId, UUID id) {
        repository.findById(id)
                .filter(bw -> bw.getUserId().equals(userId))
                .ifPresent(repository::delete);
    }

    private BloodWorkResponse mapToResponse(BloodWork entity) {
        List<BloodMarkerResponse> markerResponses = entity.getMarkers().stream()
                .map(m -> new BloodMarkerResponse(m.getId(), m.getName(), m.getValue(), m.getUnit()))
                .toList();

        return new BloodWorkResponse(
                entity.getId(),
                entity.getUserId(),
                entity.getCollectedDate(),
                entity.getNotes(),
                markerResponses
        );
    }
}
