package com.sda.company.dto;

import com.sda.company.model.JobTitle;

public class EmployeeInfoDto {
    private String name;

    private String phoneNumber;

    private Long cnp;

    private String email;

    private String address;

    private JobTitle jobTitle;

    private Double salary;

    private Integer id;

    private CompanyShortInfoDto companyShortInfoDto;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CompanyShortInfoDto getCompanyShortInfoDto() {
        return companyShortInfoDto;
    }

    public void setCompanyShortInfoDto(CompanyShortInfoDto companyShortInfoDto) {
        this.companyShortInfoDto = companyShortInfoDto;
    }
}