package com.sda.company.service.impl;

import com.sda.company.convertor.CompanyConvertor;
import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyInfoDto;
import com.sda.company.model.Company;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {


    //    @Autowired   = field injection -> not recommended (we don't have control on how java instantiates the classes)
    private final CompanyRepository companyRepository;

    //constructor injection
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyInfoDto createCompany(CompanyCreateDto companyCreateDto){
        Company company = companyRepository.save(CompanyConvertor.createDtoToEntity(companyCreateDto));
        CompanyInfoDto companyInfoDto = CompanyConvertor.entityToInfoDto(company);

        return companyInfoDto;
    }
}
