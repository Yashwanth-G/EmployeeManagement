package com.fullstack.ems.service;

import com.fullstack.ems.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(long id, EmployeeDto updatedEmployee);

    void deleteEmployee(long id);

}
