-- ============================================================
-- Exercise 1: Control Structures
-- ============================================================


-- ============================================================
-- Scenario 1: Apply 1% discount on loan interest rates
--             for customers above 60 years old
-- ============================================================
DECLARE
    v_age NUMBER;

    CURSOR c_customers IS
        SELECT c.CustomerID, c.Name, c.DOB
        FROM Customers c;
BEGIN
    FOR rec IN c_customers LOOP
        -- Calculate the customer's age
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            -- Apply a 1% discount to all loan interest rates for this customer
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for: ' || rec.Name
                || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rate discount processing completed.');
END;
/


-- ============================================================
-- Scenario 2: Set IsVIP flag to TRUE for customers
--             with a balance over $10,000
-- ============================================================
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance
        FROM Customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(rec.Name
                || ' has been promoted to VIP status. (Balance: $'
                || rec.Balance || ')');
        ELSE
            DBMS_OUTPUT.PUT_LINE(rec.Name
                || ' does not qualify for VIP. (Balance: $'
                || rec.Balance || ')');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status processing completed.');
END;
/


-- ============================================================
-- Scenario 3: Send reminders for loans due within
--             the next 30 days
-- ============================================================
DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, l.EndDate, l.LoanAmount, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name
            || ', your Loan ID ' || rec.LoanID
            || ' of amount $' || rec.LoanAmount
            || ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD')
            || '. Please ensure timely payment.');
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Loan due reminders processing completed.');
END;
/
