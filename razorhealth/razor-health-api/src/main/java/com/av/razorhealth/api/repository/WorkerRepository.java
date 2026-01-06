package com.av.razorhealth.api.repository;

import com.av.razorhealth.api.model.Worker;
import com.av.razorhealth.api.model.WorkerShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    List<Worker> findByWorkerPreferredShift(WorkerShift shift);

    List<Worker> findByWorkerPetAllergy(Boolean hasPetAllergy);

    @Query("SELECT w FROM Worker w WHERE w.employee.employeeArea = :area")
    List<Worker> findByArea(String area);

    @Query("SELECT w FROM Worker w JOIN FETCH w.availability WHERE w.availability.isActive = true")
    List<Worker> findAllActiveWithAvailability();
}