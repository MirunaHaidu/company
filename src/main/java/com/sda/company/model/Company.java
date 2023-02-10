package com.sda.company.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private Long registrationNumber;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Employee> companyEmployeeList;
    @Column
    private String createdBy;



    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Employee> getCompanyEmployeeList() {
        return companyEmployeeList;
    }

    public void setCompanyEmployeeList(List<Employee> companyEmployeeList) {
        this.companyEmployeeList = companyEmployeeList;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}