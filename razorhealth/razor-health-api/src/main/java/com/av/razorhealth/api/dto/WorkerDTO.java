package com.av.razorhealth.api.dto;

import com.av.razorhealth.api.model.Gender;
import com.av.razorhealth.api.model.WorkerShift;

public class WorkerDTO {
    private Integer workerId;
    private String workerName;
    private String workerArea;
    private Gender workerGender;
    private WorkerShift preferredShift;
    private Boolean hasPetAllergy;
    private WorkerAvailabilityDTO availability;

    // Constructors
    public WorkerDTO() {}

    public WorkerDTO(Integer workerId, String workerName, String workerArea,
                     Gender workerGender, WorkerShift preferredShift,
                     Boolean hasPetAllergy, WorkerAvailabilityDTO availability) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerArea = workerArea;
        this.workerGender = workerGender;
        this.preferredShift = preferredShift;
        this.hasPetAllergy = hasPetAllergy;
        this.availability = availability;
    }

    // Getters and Setters
    public Integer getWorkerId() { return workerId; }
    public void setWorkerId(Integer workerId) { this.workerId = workerId; }

    public String getWorkerName() { return workerName; }
    public void setWorkerName(String workerName) { this.workerName = workerName; }

    public String getWorkerArea() { return workerArea; }
    public void setWorkerArea(String workerArea) { this.workerArea = workerArea; }

    public Gender getWorkerGender() { return workerGender; }
    public void setWorkerGender(Gender workerGender) { this.workerGender = workerGender; }

    public WorkerShift getPreferredShift() { return preferredShift; }
    public void setPreferredShift(WorkerShift preferredShift) { this.preferredShift = preferredShift; }

    public Boolean getHasPetAllergy() { return hasPetAllergy; }
    public void setHasPetAllergy(Boolean hasPetAllergy) { this.hasPetAllergy = hasPetAllergy; }

    public WorkerAvailabilityDTO getAvailability() { return availability; }
    public void setAvailability(WorkerAvailabilityDTO availability) { this.availability = availability; }
}