package com.pm.billingservice.repository;

import com.pm.billingservice.model.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long> {
    boolean existsByAccountId(UUID id);
    BillingAccount findByAccountId(UUID id);
    void deleteByAccountId(UUID id);
}
