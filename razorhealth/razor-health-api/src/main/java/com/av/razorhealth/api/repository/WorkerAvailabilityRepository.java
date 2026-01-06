package com.av.razorhealth.api.repository;

import com.av.razorhealth.api.model.WorkerAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerAvailabilityRepository extends JpaRepository<WorkerAvailability, Integer> {

    List<WorkerAvailability> findByIsActive(Boolean isActive);
}