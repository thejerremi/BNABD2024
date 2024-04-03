package com.example.demobnabd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class RunAtStart {
    public RunAtStart(EmployeeRepository employeeRepository, DepartamentRepository departamentRepository) {
        super();
    }

    @Bean
    public CommandLineRunner runner(EmployeeRepository employeeRepository, DepartamentRepository departamentRepository) {
        return (args) -> {
            departamentRepository.save(new Departament("IT"));
            departamentRepository.save(new Departament("Accounting"));


            employeeRepository.save(new Employee("Jeremi", "Korowajski", new BigDecimal(4500), 1L));
            employeeRepository.save(new Employee("Anna", "Kowalska", new BigDecimal(3000), 1L));
            employeeRepository.save(new Employee("Jan", "Nowak", new BigDecimal(7000), 2L));

            employeeRepository.findAll().forEach(System.out::println);

            employeeRepository.findByLastNameStartsWith("N").forEach(System.out::println);

            System.out.println(departamentRepository.findDepartamentByIdDept(1L).getdName());
            employeeRepository.findByidDept(1L).forEach(System.out::println);

            System.out.println(departamentRepository.findDepartamentByIdDept(2L).getdName());
            employeeRepository.findByidDept(2L).forEach(System.out::println);
        };
    }
}
