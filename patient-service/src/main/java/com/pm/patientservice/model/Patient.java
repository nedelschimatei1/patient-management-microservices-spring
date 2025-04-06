package com.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    @Email
    @Column(unique = true)
    private String email;

    @NonNull
    private String address;

    @NonNull
    private LocalDate birthDate;

    @NonNull
    private LocalDate registeredDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@NonNull @Email String email) {
        this.email = email;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NonNull LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @NonNull
    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NonNull LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
