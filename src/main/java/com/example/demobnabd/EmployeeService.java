package com.example.demobnabd;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository, DepartamentRepository departamentRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }
    public List<Employee> getEmployeesByFirstNameIgnoreCase(String firstName) {
        return employeeRepository.findAllByFirstNameIgnoreCase(firstName);
    }
    public List<Employee> getEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary){
        return employeeRepository.findAllBySalaryBetween(minSalary, maxSalary);
    }
    public List<Employee> getTopNEmployeesBySalary(int n) {
        Pageable pageable = PageRequest.of(0, n);
        return employeeRepository.findTopNByOrderBySalaryDesc(pageable);
    }
    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public List<Employee> findAllEmployeesSorted() {
        return employeeRepository.findAllByOrderByLastNameAscSalaryDesc();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> saveAll(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
