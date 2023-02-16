package com.sda.company.repository;

import com.sda.company.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Optional<Employee> findByName(String name);

    List<Employee> findAllByCompanyId(Integer companyId);
}