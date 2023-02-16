package com.sda.company.dto;

public class EmployeeShortInfoDto {
    private String name;

    private Long cnp;

    private String email;

    private CompanyShortInfoDto companyShortInfoDto;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CompanyShortInfoDto getCompanyShortInfoDto() {
        return companyShortInfoDto;
    }

    public void setCompanyShortInfoDto(CompanyShortInfoDto companyShortInfoDto) {
        this.companyShortInfoDto = companyShortInfoDto;
    }
}