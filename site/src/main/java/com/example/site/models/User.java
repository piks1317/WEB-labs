package com.example.site.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{name.mess}")
    private String name;
    @NotEmpty(message = "{sname.mess}")
    private String surname;

    @NotEmpty(message = "{email.mess}")
    @Email
    @Column(name = "email")
    private String username;
    @Size(min = 8, max = 100, message = "{pswrd.mess}")
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User(String username) {
        this.username = username;
    }
}
