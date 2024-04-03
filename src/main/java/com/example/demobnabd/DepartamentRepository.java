package com.example.demobnabd;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
    Departament findDepartamentByIdDept(Long idDept);
}
