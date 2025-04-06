package com.pm.billingservice.service;

import com.google.api.Billing;
import com.pm.billingservice.model.BillingAccount;
import com.pm.billingservice.repository.BillingAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class BillingAccountService {
    private static final Logger log = LoggerFactory.getLogger(BillingAccountService.class);

    private final BillingAccountRepository billingAccountRepository;

    public BillingAccountService(BillingAccountRepository billingAccountRepository) {
        this.billingAccountRepository = billingAccountRepository;
    }

    @Transactional
    public BillingAccount createBillingAccount(UUID id) {
        if (billingAccountRepository.existsByAccountId(id)) {
            log.info("Billing account already exists for id: {}", id);
            throw new IllegalArgumentException("Billing account already exists for id: "+ id);
        }
        BillingAccount account = new BillingAccount();
        account.setAccountId(id);
        account.setStatus("ACTIVE");
        billingAccountRepository.save(account);
        log.info("Created new billing account: {}", account.toString());
        return account;
    }

    @Transactional
    public BillingAccount updateStatus(UUID id, String status) {
        if (!"ACTIVE".equals(status) && !"INACTIVE".equals(status)) {
            throw new IllegalArgumentException("Status must be either ACTIVE or INACTIVE");
        }

        if(billingAccountRepository.existsByAccountId(id)) {
          throw new IllegalArgumentException("Billing account not found with ID: " + id);
        };
        BillingAccount account = billingAccountRepository.findByAccountId(id);
        account.setStatus(status);
        billingAccountRepository.save(account);
        return account;
    }

    @Transactional
    public void deleteBillingAccount(UUID id) {
        if(billingAccountRepository.existsByAccountId(id)) {
            throw new IllegalArgumentException("Billing account not found with ID: " + id);
        };
        billingAccountRepository.deleteByAccountId(id);
    }
}