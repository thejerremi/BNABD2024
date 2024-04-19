package com.example.demobnabd.Library;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private boolean enabled;
    private String login;
    private String password;
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_data_user_data_id")
    private UserData userData;

    @PrePersist
    public void initializeUserData() {
        if (this.userData == null) {
            this.userData = new UserData();
        }
    }
}
