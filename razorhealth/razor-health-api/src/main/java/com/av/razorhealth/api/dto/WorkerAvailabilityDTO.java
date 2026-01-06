package com.av.razorhealth.api.dto;

import java.time.LocalTime;

public class WorkerAvailabilityDTO {
    private String workingDays;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer maxVisitsPerDay;
    private Boolean isActive;

    // Constructors
    public WorkerAvailabilityDTO() {}

    public WorkerAvailabilityDTO(String workingDays, LocalTime startTime,
                                 LocalTime endTime, Integer maxVisitsPerDay, Boolean isActive) {
        this.workingDays = workingDays;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxVisitsPerDay = maxVisitsPerDay;
        this.isActive = isActive;
    }

    // Getters and Setters
    public String getWorkingDays() { return workingDays; }
    public void setWorkingDays(String workingDays) { this.workingDays = workingDays; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public Integer getMaxVisitsPerDay() { return maxVisitsPerDay; }
    public void setMaxVisitsPerDay(Integer maxVisitsPerDay) { this.maxVisitsPerDay = maxVisitsPerDay; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}