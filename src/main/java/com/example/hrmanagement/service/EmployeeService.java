package com.example.hrmanagment.service;

import com.example.hrmanagment.entity.Employee;
import com.example.hrmanagment.payload.ApiResponse;
import com.example.hrmanagment.payload.EmployeeDto;
import com.example.hrmanagment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ApiResponse get() {

        List<Employee> employeeList = employeeRepository.findAll();
        return new ApiResponse("Success", true, employeeList);

    }

    public ApiResponse getById(UUID employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            return new ApiResponse("Employee not found", false);
        }
        return new ApiResponse("Success", true, optionalEmployee);
    }

    public ApiResponse edit(UUID employeeId, EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {

            return new ApiResponse("Employee not found", false);

        }

        boolean existByEmail = employeeRepository.existsByEmail(employeeDto.getEmail());
        if (existByEmail) {
            return new ApiResponse("Such an email already exists in the system", false);
        }
        Employee editingEmployee = optionalEmployee.get();
        editingEmployee.setFirstName(employeeDto.getFirstName());
        editingEmployee.setLastName(employeeDto.getLastName());
        editingEmployee.setEmail(employeeDto.getEmail());
        editingEmployee.setPassword(employeeDto.getPassword());
        editingEmployee.setSalary(employeeDto.getSalary());
        employeeRepository.save(editingEmployee);
        return new ApiResponse("Employee edited", true);
    }

    public ApiResponse delete(UUID employeeId) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            return new ApiResponse("Employee not found", false);
        }
        employeeRepository.deleteById(employeeId);
        return new ApiResponse("Employee deleted", true);
    }
}
