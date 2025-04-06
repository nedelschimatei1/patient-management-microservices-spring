package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import com.pm.billingservice.model.BillingAccount;
import com.pm.billingservice.service.BillingAccountService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    private final BillingAccountService billingAccountService;

    public BillingGrpcService(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseObserver){
            log.info("createBillingAccount request received: {}", billingRequest.toString());
        try {
            // Extract and validate data from the request
            String patientId = billingRequest.getPatientId();
            String name = billingRequest.getName();
            String email = billingRequest.getEmail();

            BillingAccount account = billingAccountService.createBillingAccount(UUID.fromString(patientId));

            log.info("Successfully made a billing account for name: {}, email:{}", name, email);

            BillingResponse response = BillingResponse.newBuilder()
                    .setAccountId(account.getAccountId().toString())
                    .setStatus(account.getStatus())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (IllegalArgumentException e) {
            log.error("Invalid request data or billing account already existing", e);
        }
    }
}
