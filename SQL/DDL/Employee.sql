CREATE TABLE UNIVERSITY.EMPLOYEE
(
	Ssn CHAR(9) CONSTRAINT PK_EMPLOYEE_SSN PRIMARY KEY,
	[Name] VARCHAR(100) NOT NULL,
	DateOfBirth DATE NOT NULL CONSTRAINT CK_EMPLOYEE_DATEOFBIRTH CHECK (DateOfBirth <= CAST(GETDATE() AS DATE)),
);

-- DROP TABLE UNIVERSITY.EMPLOYEE;