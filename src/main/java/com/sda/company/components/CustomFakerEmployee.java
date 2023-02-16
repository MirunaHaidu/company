package com.sda.company.components;

import com.github.javafaker.Faker;
import com.sda.company.model.Company;
import com.sda.company.model.Employee;
import com.sda.company.model.JobTitle;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerEmployee {

        public List<Employee> generateDummyEmployees() {
            List<Employee> dummyEmployees = new ArrayList<>();
            Faker faker = new Faker();
            for (int i = 0; i < 100; i++) {
                Employee employee = new Employee();
                employee.setName(faker.name().fullName());
                employee.setCnp(faker.number().randomNumber(13, true));
                employee.setAddress(faker.address().fullAddress());
                employee.setPhoneNumber(faker.phoneNumber().phoneNumber());
                employee.setEmail(faker.bothify("?????##@company.com"));
                employee.setSalary(faker.number().randomDouble(2, 1000, 10000));
                employee.setJobTitle(faker.options().option(JobTitle.class));
                dummyEmployees.add(employee);
            }
            return dummyEmployees;
        }
    }
