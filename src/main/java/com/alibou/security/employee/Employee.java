package com.alibou.security.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private BigDecimal salary;
}
