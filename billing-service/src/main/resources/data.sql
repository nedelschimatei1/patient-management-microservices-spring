CREATE TABLE IF NOT EXISTS billing_accounts_patients(
   status VARCHAR(20) NOT NULL,
   created_at TIMESTAMP NOT NULL,
   account_id UUID NOT NULL,
   updated_at TIMESTAMP,
   CONSTRAINT status_check CHECK (status IN ('ACTIVE', 'INACTIVE'))
);

