package com.sda.company.repository;

import com.sda.company.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //nu e obligatoriu, pentru ca avem mai jos CrudRepository (dar o lasam pt. ca poate se cere la interviu)
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Optional<Company> findByName(String name);

}
