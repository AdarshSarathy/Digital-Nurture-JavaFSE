-- ============================================================
-- Schema Setup for PL/SQL Exercises
-- Creates the necessary tables and inserts sample data
-- ============================================================

-- Drop tables if they already exist (for re-runnable script)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- ============================================================
-- Table: Customers
-- ============================================================
CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    DOB          DATE,
    Balance      NUMBER(15, 2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);

-- ============================================================
-- Table: Accounts
-- ============================================================
CREATE TABLE Accounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    AccountType  VARCHAR2(20),
    Balance      NUMBER(15, 2),
    LastModified DATE DEFAULT SYSDATE
);

-- ============================================================
-- Table: Loans
-- ============================================================
CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    LoanAmount   NUMBER(15, 2),
    InterestRate NUMBER(5, 2),
    StartDate    DATE,
    EndDate      DATE
);

-- ============================================================
-- Table: Employees
-- ============================================================
CREATE TABLE Employees (
    EmployeeID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    Department   VARCHAR2(50),
    Salary       NUMBER(15, 2),
    HireDate     DATE
);

-- ============================================================
-- Sample Data: Customers
-- ============================================================
INSERT INTO Customers VALUES (1, 'Alice Johnson',   TO_DATE('1955-03-15', 'YYYY-MM-DD'), 15000.00, 'FALSE');
INSERT INTO Customers VALUES (2, 'Bob Smith',       TO_DATE('1990-07-22', 'YYYY-MM-DD'),  8000.00, 'FALSE');
INSERT INTO Customers VALUES (3, 'Carol Williams',  TO_DATE('1960-11-05', 'YYYY-MM-DD'), 12000.00, 'FALSE');
INSERT INTO Customers VALUES (4, 'David Brown',     TO_DATE('1948-01-30', 'YYYY-MM-DD'),  5000.00, 'FALSE');
INSERT INTO Customers VALUES (5, 'Eve Davis',       TO_DATE('1985-09-12', 'YYYY-MM-DD'), 20000.00, 'FALSE');

-- ============================================================
-- Sample Data: Accounts
-- ============================================================
INSERT INTO Accounts VALUES (101, 1, 'Savings',  15000.00, SYSDATE);
INSERT INTO Accounts VALUES (102, 2, 'Checking',  8000.00, SYSDATE);
INSERT INTO Accounts VALUES (103, 3, 'Savings',  12000.00, SYSDATE);
INSERT INTO Accounts VALUES (104, 4, 'Savings',   5000.00, SYSDATE);
INSERT INTO Accounts VALUES (105, 5, 'Checking', 20000.00, SYSDATE);
INSERT INTO Accounts VALUES (106, 1, 'Checking',  3000.00, SYSDATE);
INSERT INTO Accounts VALUES (107, 5, 'Savings',   7500.00, SYSDATE);

-- ============================================================
-- Sample Data: Loans
-- ============================================================
INSERT INTO Loans VALUES (201, 1, 50000.00, 5.50, TO_DATE('2024-01-15', 'YYYY-MM-DD'), SYSDATE + 10);
INSERT INTO Loans VALUES (202, 2, 30000.00, 6.00, TO_DATE('2023-06-01', 'YYYY-MM-DD'), SYSDATE + 25);
INSERT INTO Loans VALUES (203, 3, 75000.00, 7.25, TO_DATE('2022-03-10', 'YYYY-MM-DD'), SYSDATE + 45);
INSERT INTO Loans VALUES (204, 4, 20000.00, 8.00, TO_DATE('2023-12-01', 'YYYY-MM-DD'), SYSDATE + 5);
INSERT INTO Loans VALUES (205, 5, 40000.00, 5.00, TO_DATE('2024-05-20', 'YYYY-MM-DD'), SYSDATE + 60);

-- ============================================================
-- Sample Data: Employees
-- ============================================================
INSERT INTO Employees VALUES (301, 'Frank Miller',    'IT',        60000.00, TO_DATE('2019-04-01', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (302, 'Grace Lee',       'HR',        55000.00, TO_DATE('2020-08-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (303, 'Henry Wilson',    'IT',        70000.00, TO_DATE('2018-01-20', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (304, 'Ivy Martinez',    'Finance',   65000.00, TO_DATE('2021-03-10', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (305, 'Jack Anderson',   'HR',        50000.00, TO_DATE('2022-07-05', 'YYYY-MM-DD'));

COMMIT;
