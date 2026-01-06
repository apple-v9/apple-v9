package com.av.razorhealth.api.service;

import com.av.razorhealth.api.dto.WorkerAvailabilityDTO;
import com.av.razorhealth.api.dto.WorkerDTO;
import com.av.razorhealth.api.model.Worker;
import com.av.razorhealth.api.model.WorkerAvailability;
import org.springframework.stereotype.Service;

@Service
public class WorkerMapper {

    public WorkerDTO toDTO(Worker worker) {
        if (worker == null) {
            return null;
        }

        WorkerAvailabilityDTO availabilityDTO = null;
        if (worker.getAvailability() != null) {
            availabilityDTO = toAvailabilityDTO(worker.getAvailability());
        }

        return new WorkerDTO(
                worker.getWorkerId(),
                worker.getWorkerName(),
                worker.getWorkerArea(),
                worker.getWorkerGender(),
                worker.getWorkerPreferredShift(),
                worker.getWorkerPetAllergy(),
                availabilityDTO
        );
    }

    public WorkerAvailabilityDTO toAvailabilityDTO(WorkerAvailability availability) {
        if (availability == null) {
            return null;
        }

        return new WorkerAvailabilityDTO(
                availability.getWorkingDays(),
                availability.getDailyStartTime(),
                availability.getDailyEndTime(),
                availability.getMaxVisitsPerDay(),
                availability.getIsActive()
        );
    }
}