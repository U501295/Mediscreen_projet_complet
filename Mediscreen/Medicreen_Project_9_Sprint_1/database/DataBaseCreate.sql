DROP database IF EXISTS MediScreenP9;
create database MediScreenP9;
use MediScreenP9;

CREATE TABLE patients
(
	patient_id            BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name         VARCHAR(100) NOT NULL,
    last_name          VARCHAR(100) NOT NULL,
    birth_date                DATE   NOT NULL,
    gender 				VARCHAR(100) NOT NULL,
    address 				VARCHAR(100) NOT NULL,
    phone 				VARCHAR(100) NOT NULL
);

INSERT INTO patients (first_name, last_name, birth_date,gender,address,phone) values ('TestNone', 'Test', '1966-12-31', 'F', '1 Brookside St', '100-222-3333');
INSERT INTO patients (first_name, last_name, birth_date,gender,address,phone) values ('TestBorderline', 'Test', '1945-06-24', 'M', '2 High St', '200-333-4444');
INSERT INTO patients (first_name, last_name, birth_date,gender,address,phone) values ('TestInDanger', 'Test', '2004-06-18', 'M', '3 Club Road', '300-444-5555');
INSERT INTO patients (first_name, last_name, birth_date,gender,address,phone) values ('TestEarlyOnset', 'Test', '2002-06-28', 'F', '4 Valley Dr', '400-555-6666');