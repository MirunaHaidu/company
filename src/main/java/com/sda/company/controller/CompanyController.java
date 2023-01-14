package com.sda.company.controller;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyInfoDto;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company") // this is the REST path
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // we work with REST, so the method must return a ResponseEntity object
    @PostMapping("/create")
    public ResponseEntity<CompanyInfoDto> createCompany(@RequestBody CompanyCreateDto companyCreateDto){
        CompanyInfoDto companyInfoDto = companyService.createCompany(companyCreateDto);
        return ResponseEntity.ok(companyInfoDto);
    }

}
