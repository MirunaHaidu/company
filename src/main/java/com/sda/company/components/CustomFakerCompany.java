package com.sda.company.components;

import com.github.javafaker.Faker;
import com.sda.company.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerCompany {
    public List<Company> generateDummyCompanies() {
        List<Company> dummyCompanies = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Company company = new Company();
            company.setName(faker.company().name());
            company.setRegistrationNumber(faker.number().randomNumber(5, true));
            company.setAddress(faker.address().fullAddress());
            company.setPhoneNumber(faker.phoneNumber().phoneNumber());
            company.setEmail(faker.bothify("?????##@company.com"));
            company.setCreatedBy("Custom faker");

            dummyCompanies.add(company);
        }
        return dummyCompanies;
    }
}