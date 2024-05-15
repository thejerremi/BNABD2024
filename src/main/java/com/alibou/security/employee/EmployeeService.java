package com.alibou.security.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
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
