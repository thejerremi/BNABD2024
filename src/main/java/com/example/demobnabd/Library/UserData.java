package com.example.demobnabd.Library;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDataId;

    private String pesel;
    private String city;
    private String email;
    private String name;
    private int phoneNumber;
    private String postalCode;
    private String street;
    private String surname;
}
