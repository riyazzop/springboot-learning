package com.riyaz.com.HospitalManagement.entity;

import com.riyaz.com.HospitalManagement.entity.type.BloodGroupsType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
                @UniqueConstraint(name = "unique_name_birthdate",columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date",columnList = "birthDate")
        }

)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;


    private String gender;
    @Column(unique = true)
    private String email;

    @Column(updatable = false , nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //or , both same
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private BloodGroupsType bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn //Owning Side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
