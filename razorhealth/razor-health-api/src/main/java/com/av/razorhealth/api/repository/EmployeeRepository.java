package com.av.razorhealth.api.repository;

import com.av.razorhealth.api.model.Employee;
import com.av.razorhealth.api.model.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmployeeRole(EmployeeRole role);

    List<Employee> findByEmployeeArea(String area);
}