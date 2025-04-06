-- Ensure the 'patient' table exists
CREATE TABLE IF NOT EXISTS patient
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    birth_date   DATE                NOT NULL,
    registered_date DATE                NOT NULL
);

-- Insert random UUIDs for patients
INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'f47ac10b-58cc-4372-a567-0e02b2c3d479',
       'Marcus Rivera',
       'marcus.rivera@example.com',
       '742 Evergreen Terrace, Portland',
       '1991-03-24',
       '2023-11-15'
    WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = 'f47ac10b-58cc-4372-a567-0e02b2c3d479');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT '6fa459ea-ee8a-3ca4-894e-db77e160355e',
       'Olivia Chen',
       'olivia.chen@example.com',
       '123 Sunset Blvd, Oakville',
       '1988-07-12',
       '2023-09-28'
WHERE NOT EXISTS (SELECT 1
              FROM patient
              WHERE id = '6fa459ea-ee8a-3ca4-894e-db77e160355e');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT '3e4a4c0b-c7d8-4f8c-a367-826f9d2e5cab',
       'Victor Patel',
       'victor.patel@example.com',
       '555 Lake Drive, Riverdale',
       '1979-11-30',
       '2024-01-05'
WHERE NOT EXISTS (SELECT 1
              FROM patient
              WHERE id = '3e4a4c0b-c7d8-4f8c-a367-826f9d2e5cab');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'd9e06b5e-5aaf-41fd-9e2d-66db125ce3e9',
       'Hannah Garcia',
       'hannah.garcia@example.com',
       '890 Pine Ridge, Maplewood',
       '1995-05-17',
       '2023-08-12'
WHERE NOT EXISTS (SELECT 1
              FROM patient
              WHERE id = 'd9e06b5e-5aaf-41fd-9e2d-66db125ce3e9');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'c6e34e1e-75be-4ea0-8c5f-b4f9ab1a5033',
       'Trevor Wong',
       'trevor.wong@example.com',
       '437 Birch Street, Lakeside',
       '1983-09-08',
       '2024-02-29'
WHERE NOT EXISTS (SELECT 1
              FROM patient
              WHERE id = 'c6e34e1e-75be-4ea0-8c5f-b4f9ab1a5033');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890',
       'Priya Sharma',
       'priya.sharma@example.com',
       '222 Mountain View, Hillcrest',
       '1990-12-03',
       '2023-10-19'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901',
       'Lucas Nguyen',
       'lucas.nguyen@example.com',
       '789 Ocean Avenue, Beachside',
       '1985-02-14',
       '2022-12-05'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'c3d4e5f6-a7b8-9012-c3d4-e5f6a7b89012',
       'Maya Johnson',
       'maya.johnson@example.com',
       '651 Redwood Circle, Forestville',
       '1977-08-22',
       '2023-04-30'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'c3d4e5f6-a7b8-9012-c3d4-e5f6a7b89012');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'd4e5f6a7-b8c9-0123-d4e5-f6a7b8c90123',
       'Noah Rodriguez',
       'noah.rodriguez@example.com',
       '374 Skyline Drive, Summit',
       '1993-01-19',
       '2024-03-15'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'd4e5f6a7-b8c9-0123-d4e5-f6a7b8c90123');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'e5f6a7b8-c9d0-1234-e5f6-a7b8c9d01234',
       'Sophie Miller',
       'sophie.miller@example.com',
       '901 Valley Road, Greenfield',
       '1982-06-27',
       '2023-07-11'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'e5f6a7b8-c9d0-1234-e5f6-a7b8c9d01234');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345',
       'Liam Thompson',
       'liam.thompson@example.com',
       '156 Meadow Lane, Prairie',
       '1974-04-09',
       '2022-08-17'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456',
       'Emma Washington',
       'emma.washington@example.com',
       '623 Cedar Court, Woodland',
       '1989-10-31',
       '2024-01-22'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567',
       'Aiden Kim',
       'aiden.kim@example.com',
       '488 Maple Street, Autumnville',
       '1998-09-14',
       '2023-05-08'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678',
       'Zoe Robinson',
       'zoe.robinson@example.com',
       '915 Willow Way, Brookside',
       '1981-03-05',
       '2022-11-30'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678');

INSERT INTO patient (id, name, email, address, birth_date, registered_date)
SELECT 'd0e1f2a3-b4c5-6789-d0e1-f2a3b4c56789',
       'Jackson Martinez',
       'jackson.martinez@example.com',
       '267 Harbor View, Bayside',
       '1986-12-18',
       '2023-12-09'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = 'd0e1f2a3-b4c5-6789-d0e1-f2a3b4c56789');