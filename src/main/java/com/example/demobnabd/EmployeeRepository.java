package com.example.demobnabd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String likeLastName);
    List<Employee> findByLastNameStartsWith(String firstLetter);

    List<Employee> findByidDept(long idDept);
}
