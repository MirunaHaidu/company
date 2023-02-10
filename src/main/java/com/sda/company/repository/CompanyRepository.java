package com.sda.company.repository;

import com.sda.company.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Optional<Company> findByName(String name);

}