package com.sda.company.controller;

import com.sda.company.components.CustomFakerEmployee;
import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeInfoDto;
import com.sda.company.dto.EmployeeShortInfoDto;
import com.sda.company.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employee")
@ControllerAdvice
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CustomFakerEmployee customFakerEmployee;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CustomFakerEmployee customFakerEmployee) {
        this.employeeService = employeeService;
        this.customFakerEmployee = customFakerEmployee;
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeInfoDto> createNewEmployee(@RequestBody @Valid EmployeeCreateDto employeeCreateDto) {

        return ResponseEntity.ok(employeeService.createNewEmployee(employeeCreateDto));
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeShortInfoDto>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/findEmployeeByName")
    public ResponseEntity<List<EmployeeInfoDto>> getEmployeeByName(@RequestParam String name) {
//        Optional<List<EmployeeInfoDto>> employeeInfoDto = employeeService.findEmployeeByName(name);

        return ResponseEntity.of(employeeService.findEmployeeByName(name));
    }

    @GetMapping("/generateEmployees")
    public ResponseEntity<String> generateEmployees() {
        employeeService.generateEmployees(customFakerEmployee.generateDummyEmployees());

        return ResponseEntity.ok("Employees were generated");
    }

    @PostMapping("/employNewPerson")
    public ResponseEntity<EmployeeInfoDto> employPersonToCompany(@RequestParam Integer companyId, @RequestParam Integer employeeId) {
        return ResponseEntity.ok(employeeService.employPersonToCompany(companyId, employeeId));
    }

    @DeleteMapping("/layOffEmployee")
    public void layOffEmployee(@RequestParam Integer employeeId) {
        employeeService.layOffEmployee(employeeId);
    }

    @GetMapping("/getEmployeesByCompanyId")
    public ResponseEntity<List<EmployeeShortInfoDto>> getCompanyEmployeeList(@RequestParam Integer companyId) {

        return ResponseEntity.ok(employeeService.getAllEmployeesFromCompany(companyId));
    }
}