package com.sda.company.service;

import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeInfoDto;
import com.sda.company.dto.EmployeeShortInfoDto;
import com.sda.company.model.Company;
import com.sda.company.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeInfoDto createNewEmployee(EmployeeCreateDto employeeCreateDto);

    List<EmployeeShortInfoDto> getAllEmployees();

    Optional<List<EmployeeInfoDto>> findEmployeeByName(String name);

    void generateEmployees(List<Employee> employees);

    EmployeeInfoDto employPersonToCompany(Integer companyId, Integer employeeId);

    void layOffEmployee(Integer employeeId);

    void updateEmployee(Integer id);

    Optional<Company> getEmployeePlaceOfWork(Integer id);

    List<EmployeeShortInfoDto> getAllEmployeesFromCompany(Integer companyId);
}