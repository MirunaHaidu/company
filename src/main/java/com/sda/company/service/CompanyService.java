package com.sda.company.service;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyInfoDto;

public interface CompanyService {
    CompanyInfoDto createCompany(CompanyCreateDto companyCreateDto);
}
