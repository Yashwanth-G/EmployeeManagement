package com.fullstack.ems.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="employees")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id", nullable = false, unique = true)
    private String email;
}
