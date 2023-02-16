package com.sda.company.service.impl;

import com.sda.company.convertor.EmployeeConvertor;
import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeInfoDto;
import com.sda.company.dto.EmployeeShortInfoDto;
import com.sda.company.exception.CompanyException;
import com.sda.company.exception.EmployeeException;
import com.sda.company.model.Company;
import com.sda.company.model.Employee;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.repository.EmployeeRepository;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public EmployeeInfoDto createNewEmployee(EmployeeCreateDto employeeCreateDto) {
        return EmployeeConvertor.entityToInfoDto(employeeRepository.save(EmployeeConvertor
                .createDtoToEntity(employeeCreateDto)));
    }

    @Override
    public List<EmployeeShortInfoDto> getAllEmployees() {
        List<EmployeeShortInfoDto> employeeShortInfoDto = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employeeShortInfoDto.add(EmployeeConvertor
                .entityToShortInfoDto(employee)));

        return employeeShortInfoDto;
    }

    @Override
    public Optional<List<EmployeeInfoDto>> findEmployeeByName(String name) {
        List<EmployeeInfoDto> employeeInfoDto = new ArrayList<>();
        List<EmployeeInfoDto> foundEmployees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employeeInfoDto.add(EmployeeConvertor.entityToInfoDto(employee)));
//        employeeInfoDto.stream().filter(employee -> employee.getName().equalsIgnoreCase(name))
        employeeInfoDto.stream().filter(employee -> employee.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(foundEmployees::add);

        return Optional.of(foundEmployees);
    }

    @Override
    public void generateEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
        System.out.println(employees.size() + " employees were generated!");
    }

    @Override
    public EmployeeInfoDto employPersonToCompany(Integer companyId, Integer employeeId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyException(MessageFormat.format("Could not find company with id: {0}", companyId)));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeException(MessageFormat.format("Could not find employee with id: {0}", employeeId)));
        employee.setCompany(company);

        return EmployeeConvertor.entityToInfoDto(employeeRepository.save(employee));
    }

    @Override
    public void layOffEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeException(MessageFormat.format("Could not find employee with id: {0}", employeeId)));
        Company company = employee.getCompany();
        company.getCompanyEmployeeList().remove(employee);
        companyRepository.save(company);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeShortInfoDto> getAllEmployeesFromCompany(Integer companyId) {
//        awful logic :D
//        Optional<Company> company = companyRepository.findById(companyId);
//        return company.map(Company::getCompanyEmployeeList).orElse(Collections.emptyList());
//        correct logic:
        List<Employee> employees = employeeRepository.findAllByCompanyId(companyId);
        List<EmployeeShortInfoDto> response = new ArrayList<>();
        employees.forEach(employee ->
                response.add(EmployeeConvertor.entityToShortInfoDto(employee)));

        return response;
    }

    @Override
    public void updateEmployee(Integer id) {

    }

    @Override
    public Optional<Company> getEmployeePlaceOfWork(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return Optional.empty();
    }


}