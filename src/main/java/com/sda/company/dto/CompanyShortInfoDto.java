package com.sda.company.dto;

public class CompanyShortInfoDto {
    private String name;
    private Long registrationNumber;

    public String getName() {
        return name;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}