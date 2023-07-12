package com.fullstack.ems.service.impl;

import com.fullstack.ems.dto.EmployeeDto;
import com.fullstack.ems.entity.Employee;
import com.fullstack.ems.exception.ResourceNotFoundException;
import com.fullstack.ems.repository.EmployeeRepository;
import com.fullstack.ems.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.map(employeeDto, Employee.class);
        Employee savedEmployee = repository.save(employee);
        return mapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = repository.getEmployeeById(id).get();
        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = repository.findAll();
        return employeeList.stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto updatedEmployee) {
        Employee employee = repository.findById(id).orElseThrow(() ->
           new ResourceNotFoundException("Employee is not exists with given ID: "+id));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmploye = repository.save(employee);
        return mapper.map(updatedEmploye, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exists with given ID: "+id));
        repository.delete(employee);
    }
}
