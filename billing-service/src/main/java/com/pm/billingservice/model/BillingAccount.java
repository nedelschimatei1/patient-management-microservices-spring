package com.pm.billingservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "billing_accounts_patients")
public class BillingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private UUID accountId;

    @NonNull
    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(@NonNull UUID accountId) {
        this.accountId = accountId;
    }

    @Column(nullable = false)
    private String status;

//    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BillingAccount{" +
                "accountId=" + accountId +
                ", status='" + status + '\'' +
                '}';
    }
}