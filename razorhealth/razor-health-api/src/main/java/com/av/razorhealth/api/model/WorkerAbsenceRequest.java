package com.av.razorhealth.api.model;

import java.time.LocalDate;

public class WorkerAbsenceRequest {
    private Long workerId;
    private WorkerAbsenceType absenceType;
    private LocalDate absenceDate;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public WorkerAbsenceType getAbsenceType() {
        return absenceType;
    }

    public void setAbsenceType(WorkerAbsenceType absenceType) {
        this.absenceType = absenceType;
    }

    public LocalDate getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(LocalDate absenceDate) {
        this.absenceDate = absenceDate;
    }
}
