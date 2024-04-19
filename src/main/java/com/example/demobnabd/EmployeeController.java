package com.example.demobnabd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Iterable<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/id")
    public Optional<Employee> getById(@RequestParam Long index){
        return employeeService.findById(index);
    }
    @GetMapping("/byFirstName")
    public List<Employee> getEmployeesByFirstName(@RequestParam String firstName) {
        return employeeService.getEmployeesByFirstNameIgnoreCase(firstName);
    }
    @GetMapping("/bySalary")
    public List<Employee> getEmployeesBySalaryRange(@RequestParam BigDecimal minSalary, @RequestParam BigDecimal maxSalary){
        return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
    }
    @GetMapping("/topNBySalary")
    public List<Employee> getTopNEmployeesBySalary(@RequestParam int n) {
        return employeeService.getTopNEmployeesBySalary(n);
    }
    @GetMapping(value = "/{employeeId}")
    public Optional<Employee> getId(@PathVariable("employeeId") Long employeeId){
        return employeeService.findById(employeeId);
    }
    @GetMapping("/sorted")
    public List<Employee> getAllEmployeesSorted() {
        return employeeService.findAllEmployeesSorted();
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @PostMapping("/employees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employeeList){
        return employeeService.saveAll(employeeList);
    }
    @PutMapping(path = "{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee updatedEmployee){
        Optional<Employee> employeeOptional = employeeService.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setFirstName(updatedEmployee.getLastName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setIdDept(updatedEmployee.getIdDept());

            employeeService.save(existingEmployee);
            return ResponseEntity.ok("Employee with ID " + employeeId + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") long employeeId){
        employeeService.deleteById(employeeId);
    }
}
