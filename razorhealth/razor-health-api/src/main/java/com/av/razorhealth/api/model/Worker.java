package com.av.razorhealth.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rz_workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Integer workerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
  //  @Column(name = "employee_id")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "worker_preferred_shift", nullable = false)
    private WorkerShift workerPreferredShift;

    @Column(name = "worker_pet_allergy", nullable = false)
    private Boolean workerPetAllergy = false;

    @OneToOne(mappedBy = "worker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WorkerAvailability availability;

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
    public Worker() {}

    public Worker(Employee employee, WorkerShift workerPreferredShift, Boolean workerPetAllergy) {
        this.employee = employee;
        this.workerPreferredShift = workerPreferredShift;
        this.workerPetAllergy = workerPetAllergy;
    }

    // Convenience methods
    public String getWorkerName() {
        return employee != null ? employee.getEmployeeName() : null;
    }

    public String getWorkerArea() {
        return employee != null ? employee.getEmployeeArea() : null;
    }

    public Gender getWorkerGender() {
        return employee != null ? employee.getEmployeeGender() : null;
    }

    // Getters and Setters
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public WorkerShift getWorkerPreferredShift() {
        return workerPreferredShift;
    }

    public void setWorkerPreferredShift(WorkerShift workerPreferredShift) {
        this.workerPreferredShift = workerPreferredShift;
    }

    public Boolean getWorkerPetAllergy() {
        return workerPetAllergy;
    }

    public void setWorkerPetAllergy(Boolean workerPetAllergy) {
        this.workerPetAllergy = workerPetAllergy;
    }

    public WorkerAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(WorkerAvailability availability) {
        this.availability = availability;
        if (availability != null) {
            availability.setWorker(this);
        }
    }

    public LocalDateTime getRzCreatedAt() {
        return rzCreatedAt;
    }

    public LocalDateTime getRzLastUpdatedAt() {
        return rzLastUpdatedAt;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", employeeName='" + getWorkerName() + '\'' +
                ", workerPreferredShift=" + workerPreferredShift +
                ", workerPetAllergy=" + workerPetAllergy +
                '}';
    }
}