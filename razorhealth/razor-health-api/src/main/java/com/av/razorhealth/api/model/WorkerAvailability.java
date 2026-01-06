package com.av.razorhealth.api.model;

import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Table(name = "rz_worker_availability")
public class WorkerAvailability {

    @Id
    @Column(name = "worker_id")
    private Integer workerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(name = "working_days", nullable = false, length = 50)
    private String workingDays;

    @Column(name = "daily_start_time", nullable = false)
    private LocalTime dailyStartTime;

    @Column(name = "daily_end_time", nullable = false)
    private LocalTime dailyEndTime;

    @Column(name = "max_visits_per_day")
    private Integer maxVisitsPerDay = 6;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "rz_created_at", updatable = false)
    private LocalDateTime rzCreatedAt;

    @Column(name = "rz_last_updated_at")
    private LocalDateTime rzLastUpdatedAt;

    // Lifecycle callbacks
    @PrePersist
    protected void onCreate() {
        rzCreatedAt = LocalDateTime.now();
        rzLastUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        rzLastUpdatedAt = LocalDateTime.now();
    }

    // Constructors
    public WorkerAvailability() {}

    public WorkerAvailability(String workingDays, LocalTime dailyStartTime,
                              LocalTime dailyEndTime, Integer maxVisitsPerDay) {
        this.workingDays = workingDays;
        this.dailyStartTime = dailyStartTime;
        this.dailyEndTime = dailyEndTime;
        this.maxVisitsPerDay = maxVisitsPerDay;
    }

    // Helper methods
    public Set<DayOfWeek> getWorkingDaysAsSet() {
        if (workingDays == null || workingDays.isEmpty()) {
            return new HashSet<>();
        }

        // Handle "MON-FRI" shorthand
        if (workingDays.contains("-")) {
            if ("MON-FRI".equals(workingDays)) {
                return Set.of(
                        DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                        DayOfWeek.THURSDAY, DayOfWeek.FRIDAY
                );
            }
            // Add more shorthands if needed
        }

        // Handle "MON,WED,FRI" format
        return Arrays.stream(workingDays.split(","))
                .map(String::trim)
                .map(this::parseDayOfWeek)
                .collect(Collectors.toSet());
    }

    private DayOfWeek parseDayOfWeek(String day) {
        return switch (day.toUpperCase()) {
            case "MON", "MONDAY" -> DayOfWeek.MONDAY;
            case "TUE", "TUESDAY" -> DayOfWeek.TUESDAY;
            case "WED", "WEDNESDAY" -> DayOfWeek.WEDNESDAY;
            case "THU", "THURSDAY" -> DayOfWeek.THURSDAY;
            case "FRI", "FRIDAY" -> DayOfWeek.FRIDAY;
            case "SAT", "SATURDAY" -> DayOfWeek.SATURDAY;
            case "SUN", "SUNDAY" -> DayOfWeek.SUNDAY;
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };
    }

    public boolean isAvailableOn(DayOfWeek dayOfWeek) {
        return getWorkingDaysAsSet().contains(dayOfWeek);
    }

    public boolean isAvailableAt(LocalTime time) {
        return !time.isBefore(dailyStartTime) && !time.isAfter(dailyEndTime);
    }

    // Getters and Setters
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public LocalTime getDailyStartTime() {
        return dailyStartTime;
    }

    public void setDailyStartTime(LocalTime dailyStartTime) {
        this.dailyStartTime = dailyStartTime;
    }

    public LocalTime getDailyEndTime() {
        return dailyEndTime;
    }

    public void setDailyEndTime(LocalTime dailyEndTime) {
        this.dailyEndTime = dailyEndTime;
    }

    public Integer getMaxVisitsPerDay() {
        return maxVisitsPerDay;
    }

    public void setMaxVisitsPerDay(Integer maxVisitsPerDay) {
        this.maxVisitsPerDay = maxVisitsPerDay;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getRzCreatedAt() {
        return rzCreatedAt;
    }

    public LocalDateTime getRzLastUpdatedAt() {
        return rzLastUpdatedAt;
    }

    @Override
    public String toString() {
        return "WorkerAvailability{" +
                "workerId=" + workerId +
                ", workingDays='" + workingDays + '\'' +
                ", dailyStartTime=" + dailyStartTime +
                ", dailyEndTime=" + dailyEndTime +
                ", maxVisitsPerDay=" + maxVisitsPerDay +
                ", isActive=" + isActive +
                '}';
    }
}