package com.alibou.security.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public Iterable<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/id/")
    public Optional<Employee> getById(@RequestParam Long index){
        return employeeService.findById(index);
    }



    @GetMapping(value = "/{employeeId}")
    public Optional<Employee> getId(@PathVariable("employeeId") Long employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('admin:create')")
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return employeeService.save(employee);
    }
    @PostMapping("/employees")
    @PreAuthorize("hasAuthority('admin:create')")

    public List<Employee> addEmployees(@RequestBody List<Employee> employeeList){
        return employeeService.saveAll(employeeList);
    }
    @PutMapping(path = "{employeeId}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee updatedEmployee){
        Optional<Employee> employeeOptional = employeeService.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setFirstname(updatedEmployee.getFirstname());
            existingEmployee.setLastname(updatedEmployee.getLastname());
            existingEmployee.setSalary(updatedEmployee.getSalary());

            employeeService.save(existingEmployee);
            return ResponseEntity.ok("Employee with ID " + employeeId + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/del/{employeeId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteEmployee(@PathVariable("employeeId") long employeeId){
        employeeService.deleteById(employeeId);
    }
}