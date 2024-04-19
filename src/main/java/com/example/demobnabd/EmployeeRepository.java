package com.example.demobnabd;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String likeLastName);
    List<Employee> findByLastNameStartsWith(String firstLetter);

    List<Employee> findByidDept(long idDept);
    List<Employee> findAllByOrderByLastNameAscSalaryDesc();

    List<Employee> findAllByFirstNameIgnoreCase(String firstName);
    List<Employee> findAllBySalaryBetween(BigDecimal minSalary, BigDecimal maxSalary);
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> findTopNByOrderBySalaryDesc(Pageable pageable);
}
