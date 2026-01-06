package com.av.razorhealth.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rz_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false, length = 100)
    private String employeeName;

    @Column(name = "employee_address", nullable = false, length = 255)
    private String employeeAddress;

    @Column(name = "employee_area", nullable = false, length = 255)
    private String employeeArea;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_role", nullable = false)
    private EmployeeRole employeeRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_gender")
    private Gender employeeGender = Gender.NONE;

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
    public Employee() {}

    public Employee(String employeeName, String employeeAddress, String employeeArea,
                    EmployeeRole employeeRole, Gender employeeGender) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeArea = employeeArea;
        this.employeeRole = employeeRole;
        this.employeeGender = employeeGender;
    }

    // Getters and Setters
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeArea() {
        return employeeArea;
    }

    public void setEmployeeArea(String employeeArea) {
        this.employeeArea = employeeArea;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Gender getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Gender employeeGender) {
        this.employeeGender = employeeGender;
    }

    public LocalDateTime getRzCreatedAt() {
        return rzCreatedAt;
    }

    public LocalDateTime getRzLastUpdatedAt() {
        return rzLastUpdatedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeArea='" + employeeArea + '\'' +
                ", employeeRole=" + employeeRole +
                ", employeeGender=" + employeeGender +
                '}';
    }
}