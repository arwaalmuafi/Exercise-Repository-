package com.example.exerciseprepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 5, message = "Name must be more than 4 characters")
    private String name;

    @NotNull(message = "Username cannot be null")
    @Size(min = 5, message = "Username must be more than 4 characters")
    @Column(columnDefinition = "varchar (10) not null ")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Column(columnDefinition = "varchar (10) not null")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be valid")
    @Column(columnDefinition = "varchar (30) not null")
    private String email;

    @NotNull(message = "Role cannot be null")
    @Pattern(regexp = "^(user|admin)$", message = "Role must be either 'user' or 'admin'")
    @Column(columnDefinition = "varchar (10) not null")
    private String role;

    @NotNull(message = "Age cannot be null")
    @Min(value = 0, message = "Age must be a positive integer")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
