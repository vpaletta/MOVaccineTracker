#Created by Miles Godfrey and Victor Paletta
CREATE DATABASE ateam;

CREATE TABLE doctor 
            (DOCID INTEGER NOT NULL, 
            D_PASSWORD VARCHAR(100) NOT NULL,
            FNAME VARCHAR(30),
            LNAME VARCHAR(30),
            EMAIL VARCHAR(50),
            CONSTRAINT doctor_PK PRIMARY KEY (DOCID));

CREATE TABLE patient 
            (PatientID VARCHAR(100) NOT NULL,
            firstName VARCHAR(30),
            middleName VARCHAR(30),
            lastName VARCHAR(50),
            DOB DATE,
            SEX VARCHAR(30),
            RACE VARCHAR(30),
            FACILITY INTEGER(1),
            CITY VARCHAR(30),
            STATE VARCHAR(30),
            EMAIL VARCHAR(30),
            PHONE VARCHAR(30),
            VACCINE VARCHAR(30), 
            VaccAdminSite VARCHAR(30),
            DOSE INTEGER(1),
            AdminDate DATE,
            AdverseReact VARCHAR(30),
            vaccEligible VARCHAR(30),
            CONSTRAINT patient_PK PRIMARY KEY (PatientID));

INSERT INTO doctor (EMAIL, FNAME, LNAME, D_PASSWORD, DOCID) values 
('mgodfrey@gmail.com', 'Miles', 'Godfrey', '1234' , 1);
 
INSERT INTO doctor (EMAIL, FNAME, LNAME, D_PASSWORD, DOCID) values 
('vpaletta2011@gmail.com', 'Victor', 'Paletta', '4321' , 2);

INSERT INTO doctor (EMAIL, FNAME, LNAME, D_PASSWORD, DOCID) values 
('babate@gmail.com', 'Bekalu', 'Abate', '1234', 3);

INSERT INTO doctor (EMAIL, FNAME, LNAME, D_PASSWORD, DOCID) values 
('cschulte@gmail.com', 'Colin', 'Schulte', '1234' ,4);
