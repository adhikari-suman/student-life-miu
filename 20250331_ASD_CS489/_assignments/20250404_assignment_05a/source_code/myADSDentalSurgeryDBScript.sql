-- Create Database
CREATE DATABASE IF NOT EXISTS ads_dental_surgery_db;
USE ads_dental_surgery_db;

-- USERS (superclass)
CREATE TABLE IF NOT EXISTS Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL
);

-- DENTISTS (inherits from Users)
CREATE TABLE IF NOT EXISTS Dentists (
    id INT PRIMARY KEY,
    specialization VARCHAR(100) NOT NULL,
    FOREIGN KEY (id) REFERENCES Users(id)
);

-- OFFICE MANAGERS (inherits from Users)
CREATE TABLE IF NOT EXISTS OfficeManagers (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Users(id)
);

-- PATIENTS (inherits from Users)
CREATE TABLE IF NOT EXISTS Patients (
    id INT PRIMARY KEY,
    patient_no VARCHAR(10) NOT NULL,
    mailing_address TEXT NOT NULL,
    date_of_birth DATE NOT NULL,
    FOREIGN KEY (id) REFERENCES Users(id)
);

-- SURGERIES
CREATE TABLE IF NOT EXISTS Surgeries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location TEXT NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

-- APPOINTMENTS
CREATE TABLE IF NOT EXISTS Appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    dentist_id INT,
    surgery_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    appointment_status INT NOT NULL, -- 0 = scheduled, 1 = cancelled, 2 = completed
    FOREIGN KEY (patient_id) REFERENCES Patients(id),
    FOREIGN KEY (dentist_id) REFERENCES Dentists(id),
    FOREIGN KEY (surgery_id) REFERENCES Surgeries(id)
);

-- BILLS
CREATE TABLE IF NOT EXISTS Bills (
    id INT PRIMARY KEY, -- same as appointment id
    amount DECIMAL(10, 2) NOT NULL,
    bill_status INT DEFAULT 0, -- 0 = unpaid, 1 = paid
    FOREIGN KEY (id) REFERENCES Appointments(id) ON DELETE CASCADE
);


-- Finish DDL
-- Add dummy data given


-- USERS
INSERT INTO Users (first_name, last_name, username, password_hash, phone_number, email)
VALUES
-- Dentists
('Tony', 'Smith', 'tonysmith', 'password_hash_1', '555-1234', 'tony.smith@email.com'),   -- ID 1
('Helen', 'Pearson', 'helenpearson', 'password_hash_2', '555-2345', 'helen.pearson@email.com'), -- ID 2
('Robin', 'Plevin', 'robinplevin', 'password_hash_3', '555-3456', 'robin.plevin@email.com'),   -- ID 3

-- Patients
('Gillian', 'White', 'gillianwhite', 'password_hash_4', '555-4567', 'gillian.white@email.com'), -- ID 4
('Jill', 'Bell', 'jillbell', 'password_hash_5', '555-5678', 'jill.bell@email.com'),             -- ID 5
('Ian', 'MacKay', 'ianmackay', 'password_hash_6', '555-6789', 'ian.mackay@email.com'),          -- ID 6
('John', 'Walker', 'johnwalker', 'password_hash_7', '555-7890', 'john.walker@email.com'),       -- ID 7

-- Office Manager
('Sarah', 'Evans', 'sarahevans', 'password_hash_8', '555-9999', 'sarah.evans@email.com');       -- ID 8

-- DENTISTS
INSERT INTO Dentists (id, specialization)
VALUES
(1, 'General Dentistry'),
(2, 'Orthodontics'),
(3, 'Periodontics');

-- OFFICE MANAGER
INSERT INTO OfficeManagers (id)
VALUES
(8);

-- PATIENTS
INSERT INTO Patients (id, patient_no, mailing_address, date_of_birth)
VALUES
(4, 'P100', '123 Oak St, Springfield', '1985-07-10'),
(5, 'P105', '456 Pine St, Springfield', '1990-03-12'),
(6, 'P108', '789 Maple St, Springfield', '1982-11-05'),
(7, 'P110', '101 Birch St, Springfield', '1995-06-20');

-- SURGERIES
INSERT INTO Surgeries (name, location, phone_number)
VALUES
('S15', 'Room 1, Clinic A', '555-1111'), -- ID 1
('S10', 'Room 2, Clinic B', '555-2222'), -- ID 2
('S13', 'Room 3, Clinic C', '555-3333'); -- ID 3

-- APPOINTMENTS
INSERT INTO Appointments (patient_id, dentist_id, surgery_id, appointment_date, appointment_time, appointment_status)
VALUES
(4, 1, 1, '2013-09-12', '10:00', 0),  -- Tony, Gillian, S15
(5, 1, 1, '2013-09-12', '12:00', 0),  -- Tony, Jill, S15
(6, 2, 2, '2013-09-12', '10:00', 0),  -- Helen, Ian, S10
(6, 2, 2, '2013-09-14', '14:00', 0),  -- Helen, Ian, S10
(5, 3, 1, '2013-09-14', '16:30', 0),  -- Robin, Jill, S15
(7, 3, 3, '2013-09-15', '18:00', 0);  -- Robin, John, S13

-- BILLS
INSERT INTO Bills (id, amount, bill_status)
VALUES
(1, 0.00, 0),
(2, 0.00, 0),
(3, 0.00, 0),
(4, 0.00, 0),
(5, 0.00, 0),
(6, 0.00, 0);


-- Inserts complete

-- Display dummy data
SELECT
    -- Dentist Name (from Users table)
    CONCAT(ud.first_name, ' ', ud.last_name) AS dentist_name,

    -- Patient Info (from Users table)
    p.patient_no AS pat_no,
    CONCAT(up.first_name, ' ', up.last_name) AS pat_name,

    -- Appointment Info with formatted date (two-digit year)
    DATE_FORMAT(a.appointment_date, '%d-%b-%y') AS appointment_date, -- Format the date as '12-Sep-12'
    a.appointment_time,

    -- Surgery Info
    s.name AS surgery_no
FROM
    Appointments a
JOIN
    Dentists d ON a.dentist_id = d.id
JOIN
    Users ud ON d.id = ud.id -- Join Users table for dentist's name
JOIN
    Patients p ON a.patient_id = p.id
JOIN
    Users up ON p.id = up.id -- Join Users table for patient's name
JOIN
    Surgeries s ON a.surgery_id = s.id
ORDER BY
    a.appointment_date, -- Then, order by appointment date
    dentist_name DESC, -- First, order by dentist's name
    a.appointment_time; -- Lastly, order by appointment time
 
-- Now do the queries for labs

-- Display the list of ALL Dentists registered in the system, sorted in ascending
-- order of their lastNames
SELECT u.first_name, u.last_name, d.specialization FROM Dentists d
    INNER JOIN Users u
        ON d.id = u.id
ORDER BY
    u.last_name;

-- Display the list of ALL Appointments for a given Dentist by their dentist_Id
-- number. Include in the result, the Patient information.
SELECT a.appointment_date,
       a.appointment_time,
       patient_no,
       CONCAT(u.first_name, ' ', u.last_name) AS patientName,
       p.mailing_address,
       p.date_of_birth
FROM Appointments a
    INNER JOIN Patients p
        ON a.patient_id = p.id
    INNER JOIN Users u
        ON u.id = p.id
WHERE
    dentist_id = 3;

-- Display the list of ALL Appointments that have been scheduled at a Surgery Location
SELECT a.appointment_date,
       a.appointment_time
FROM Appointments a
    INNER JOIN Surgeries s ON a.surgery_id = s.id
WHERE
    s.location = 'Room 1, Clinic A';


-- Display the list of the Appointments booked for a given Patient on a given Date.
SELECT *
FROM Appointments a
WHERE
    a.appointment_date = '2013-09-12'
  AND
    a.patient_id = 4;