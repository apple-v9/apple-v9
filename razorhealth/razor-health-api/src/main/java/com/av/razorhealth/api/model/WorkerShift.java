package com.av.razorhealth.api.model;

import java.time.LocalTime;

public enum WorkerShift {
    MORNING(LocalTime.of(6, 0), LocalTime.of(14, 0)),
    AFTERNOON(LocalTime.of(14, 0), LocalTime.of(22, 0)),
    NIGHT(LocalTime.of(22, 0), LocalTime.of(6, 0));

    private final LocalTime startTime;
    private final LocalTime endTime;

    WorkerShift(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean isWithinShift(LocalTime time) {
        if (this == NIGHT) {
            // Night shift wraps around midnight
            return time.isAfter(startTime) || time.isBefore(endTime);
        }
        return !time.isBefore(startTime) && !time.isAfter(endTime);
    }
}