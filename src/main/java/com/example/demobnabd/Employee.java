package com.example.demobnabd;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private BigDecimal salary;

    private Long idDept;

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, BigDecimal salary, Long idDept) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.idDept = idDept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", idDept=" + idDept +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getIdDept() {
        return idDept;
    }

    public void setIdDept(Long idDept) {
        this.idDept = idDept;
    }
}
