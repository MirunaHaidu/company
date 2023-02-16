package com.sda.company.convertor;

import com.sda.company.dto.EmployeeInfoDto;
import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeShortInfoDto;
import com.sda.company.model.Employee;

public class EmployeeConvertor {

    public static Employee createDtoToEntity(EmployeeCreateDto employeeCreateDto) {
        Employee employee = new Employee();
        employee.setName(employeeCreateDto.getName());
        employee.setAddress(employeeCreateDto.getAddress());
        employee.setEmail(employeeCreateDto.getEmail());
        employee.setPhoneNumber(employeeCreateDto.getPhoneNumber());
        employee.setCnp(employeeCreateDto.getCnp());
        employee.setJobTitle(employeeCreateDto.getJobTitle());
        employee.setSalary(employeeCreateDto.getSalary());

        return employee;
    }

    public static EmployeeInfoDto entityToInfoDto(Employee employee) {
        EmployeeInfoDto employeeInfoDto = new EmployeeInfoDto();
        employeeInfoDto.setName(employee.getName());
        employeeInfoDto.setAddress(employee.getAddress());
        employeeInfoDto.setEmail(employee.getEmail());
        employeeInfoDto.setPhoneNumber(employee.getPhoneNumber());
        employeeInfoDto.setCnp(employee.getCnp());
        employeeInfoDto.setJobTitle(employee.getJobTitle());
        employeeInfoDto.setSalary(employee.getSalary());
        employeeInfoDto.setId(employee.getId());
        if (employee.getCompany() != null) {
            employeeInfoDto.setCompanyShortInfoDto(CompanyConvertor.entityToShortInfoDto(employee.getCompany()));
        }
        return employeeInfoDto;
    }

    public static EmployeeShortInfoDto entityToShortInfoDto(Employee employee) {
        EmployeeShortInfoDto employeeShortInfoDto = new EmployeeShortInfoDto();
        employeeShortInfoDto.setName(employee.getName());
        employeeShortInfoDto.setCnp(employee.getCnp());
        employeeShortInfoDto.setEmail(employee.getEmail());
        if (employee.getCompany() != null) {
            employeeShortInfoDto.setCompanyShortInfoDto(CompanyConvertor.entityToShortInfoDto(employee.getCompany()));
        }


        return employeeShortInfoDto;
    }
}