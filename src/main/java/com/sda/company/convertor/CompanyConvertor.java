package com.sda.company.convertor;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyInfoDto;
import com.sda.company.dto.CompanyShortInfoDto;
import com.sda.company.model.Company;

public class CompanyConvertor {

    public static Company createDtoToEntity(CompanyCreateDto companyCreateDto) {
        Company company = new Company();
        company.setName(companyCreateDto.getName());
        company.setAddress(companyCreateDto.getAddress());
        company.setEmail(companyCreateDto.getEmail());
        company.setPhoneNumber(companyCreateDto.getPhoneNumber());
        company.setRegistrationNumber(companyCreateDto.getRegistrationNumber());
        company.setCreatedBy(companyCreateDto.getCreatedBy());

        return company;
    }

    public static CompanyInfoDto entityToInfoDto(Company company) {
        CompanyInfoDto companyInfoDto = new CompanyInfoDto();
        companyInfoDto.setName(company.getName());
        companyInfoDto.setAddress(company.getAddress());
        companyInfoDto.setEmail(company.getEmail());
        companyInfoDto.setPhoneNumber(company.getPhoneNumber());
        companyInfoDto.setRegistrationNumber(company.getRegistrationNumber());
        companyInfoDto.setId(company.getId());
        companyInfoDto.setCreatedBy(company.getCreatedBy());

        return companyInfoDto;
    }

    public static CompanyShortInfoDto entityToShortInfoDto(Company company) {
        CompanyShortInfoDto companyShortInfoDto = new CompanyShortInfoDto();
        companyShortInfoDto.setName(company.getName());
        companyShortInfoDto.setRegistrationNumber(company.getRegistrationNumber());

        return companyShortInfoDto;
    }
}