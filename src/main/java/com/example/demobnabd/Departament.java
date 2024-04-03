package com.example.demobnabd;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDept;
    private String dName;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "idDept", foreignKey = @ForeignKey(name="FK_EmpDept"))
    private List<Employee> employeeList;

    @Override
    public String toString() {
        return "Departament{" +
                "idDept=" + idDept +
                ", dName='" + dName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public Long getIdDept() {
        return idDept;
    }

    public void setIdDept(Long idDept) {
        this.idDept = idDept;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Departament() {
    }

    public Departament(String dName) {
        this.dName = dName;
    }
}
