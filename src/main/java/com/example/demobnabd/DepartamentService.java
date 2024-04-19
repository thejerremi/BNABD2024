package com.example.demobnabd;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartamentService {
    private final DepartamentRepository departamentRepository;

    public DepartamentService(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }

    public Optional<Departament> findById(Long id){
        return departamentRepository.findById(id);
    }

    public Iterable<Departament> findAll(){
        return departamentRepository.findAll();
    }

    public Departament save(Departament departament){
        return departamentRepository.save(departament);
    }
    //    public Departament update(Long departamentId)
    public void deleteById(Long id) {
        departamentRepository.deleteById(id);
    }
}
