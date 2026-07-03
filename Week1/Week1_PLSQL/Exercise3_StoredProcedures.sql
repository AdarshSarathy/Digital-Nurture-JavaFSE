-- ============================================================
-- Exercise 3: Stored Procedures
-- ============================================================


-- ============================================================
-- Scenario 1: ProcessMonthlyInterest
-- Calculates and updates the balance of all savings accounts
-- by applying a 1% interest rate to the current balance.
-- ============================================================
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_new_balance NUMBER(15, 2);

    CURSOR c_savings IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings';
BEGIN
    FOR rec IN c_savings LOOP
        v_new_balance := rec.Balance + (rec.Balance * 1 / 100);

        UPDATE Accounts
        SET Balance      = v_new_balance,
            LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Account ID ' || rec.AccountID
            || ': $' || rec.Balance
            || ' -> $' || v_new_balance);
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing completed.');
END;
/

-- Execute the procedure
BEGIN
    ProcessMonthlyInterest;
END;
/


-- ============================================================
-- Scenario 2: UpdateEmployeeBonus
-- Updates the salary of employees in a given department
-- by adding a bonus percentage passed as a parameter.
-- ============================================================
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department   IN VARCHAR2,
    p_bonus_pct    IN NUMBER
) IS
    v_new_salary NUMBER(15, 2);

    CURSOR c_employees IS
        SELECT EmployeeID, Name, Salary
        FROM Employees
        WHERE Department = p_department;
BEGIN
    FOR rec IN c_employees LOOP
        v_new_salary := rec.Salary + (rec.Salary * p_bonus_pct / 100);

        UPDATE Employees
        SET Salary = v_new_salary
        WHERE EmployeeID = rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Employee: ' || rec.Name
            || ' | Old Salary: $' || rec.Salary
            || ' | New Salary: $' || v_new_salary);
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus update for department "'
        || p_department || '" completed.');
END;
/

-- Execute the procedure (10% bonus for IT department)
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/


-- ============================================================
-- Scenario 3: TransferFunds
-- Transfers a specified amount from one account to another,
-- checking that the source account has sufficient balance.
-- ============================================================
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_target_account IN NUMBER,
    p_amount         IN NUMBER
) IS
    v_source_balance NUMBER(15, 2);
BEGIN
    -- Retrieve the current balance of the source account
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account;

    -- Check for sufficient funds
    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in Account ID '
            || p_source_account
            || '. Available: $' || v_source_balance
            || ', Requested: $' || p_amount);
        RETURN;
    END IF;

    -- Debit the source account
    UPDATE Accounts
    SET Balance      = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_account;

    -- Credit the target account
    UPDATE Accounts
    SET Balance      = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_target_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount
        || ' from Account ' || p_source_account
        || ' to Account ' || p_target_account || '.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs not found.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Execute the procedure (transfer $500 from Account 101 to Account 102)
BEGIN
    TransferFunds(101, 102, 500);
END;
/
