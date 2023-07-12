package com.fullstack.ems.repository;

import com.fullstack.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> getEmployeeById(long id);

}
