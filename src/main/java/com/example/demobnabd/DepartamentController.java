package com.example.demobnabd;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departaments")
public class DepartamentController {
    private DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }
    @GetMapping("/all")
    public Iterable<Departament> getAll(){
        return departamentService.findAll();
    }
    @GetMapping("/id")
    public Optional<Departament> getById(@RequestParam Long index){
        return departamentService.findById(index);
    }
    @GetMapping(value = "/{departamentId}")
    public Optional<Departament> getId(@PathVariable("departamentId") Long departamentId){
        return departamentService.findById(departamentId);
    }
    @PostMapping
    public Departament addDepartament(@RequestBody Departament departament){
        return departamentService.save(departament);
    }
    //    @PutMapping(path = "{employeeId}")
//    public Employee updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee){
//
//        return employeeService.save(employeeId);
//    }
    @DeleteMapping("{departamentId}")
    public void deleteDepartament(@PathVariable("departamentId") long departamentId){
        departamentService.deleteById(departamentId);
    }

}
