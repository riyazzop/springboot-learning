package com.riyaz.RestAPIExample.entity;

import com.riyaz.RestAPIExample.types.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String rollNo;

    @Column(unique = true ,nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}

