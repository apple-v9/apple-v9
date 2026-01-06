package com.av.razorhealth.api.controller;

import com.av.razorhealth.api.dto.WorkerDTO;
import com.av.razorhealth.api.dto.WorkerAvailabilityDTO;
import com.av.razorhealth.api.model.Worker;
import com.av.razorhealth.api.repository.WorkerRepository;
import com.av.razorhealth.api.repository.WorkerAvailabilityRepository;
import com.av.razorhealth.api.service.WorkerMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerRepository workerRepository;
    private final WorkerAvailabilityRepository availabilityRepository;
    private final WorkerMapper workerMapper;

    public WorkerController(WorkerRepository workerRepository,
                            WorkerAvailabilityRepository availabilityRepository,
                            WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.availabilityRepository = availabilityRepository;
        this.workerMapper = workerMapper;
    }

    @GetMapping
    public List<WorkerDTO> getAllWorkers() {
        return workerRepository.findAll()
                .stream()
                .map(workerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkerDTO getWorkerById(@PathVariable Integer id) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found with id: " + id));
        return workerMapper.toDTO(worker);
    }

    @GetMapping("/{id}/availability")
    public WorkerAvailabilityDTO getWorkerAvailability(@PathVariable Integer id) {
        return availabilityRepository.findById(id)
                .map(workerMapper::toAvailabilityDTO)
                .orElseThrow(() -> new RuntimeException("Availability not found for worker: " + id));
    }

    @GetMapping("/active")
    public List<WorkerDTO> getActiveWorkers() {
        return workerRepository.findAllActiveWithAvailability()
                .stream()
                .map(workerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/area/{area}")
    public List<WorkerDTO> getWorkersByArea(@PathVariable String area) {
        return workerRepository.findByArea(area)
                .stream()
                .map(workerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/no-pet-allergy")
    public List<WorkerDTO> getWorkersWithoutPetAllergy() {
        return workerRepository.findByWorkerPetAllergy(false)
                .stream()
                .map(workerMapper::toDTO)
                .collect(Collectors.toList());
    }
}