package ch.schule.bank.junit5;

import ch.schule.Bank;
import ch.schule.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTests {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void testCreateSavingsAccount() {
        String accountId = bank.createSavingsAccount();
        assertNotNull(accountId);
        assertTrue(accountId.startsWith("S-"));
        assertEquals(0, bank.getBalance(accountId));
    }

    @Test
    void testCreatePromoYouthSavingsAccount() {
        String accountId = bank.createPromoYouthSavingsAccount();
        assertNotNull(accountId);
        assertTrue(accountId.startsWith("Y-"));
        assertEquals(0, bank.getBalance(accountId));
    }

    @Test
    void testCreateSalaryAccountValid() {
        String accountId = bank.createSalaryAccount(-5000);
        assertNotNull(accountId);
        assertTrue(accountId.startsWith("P-"));
        assertEquals(0, bank.getBalance(accountId));
    }

    @Test
    void testCreateSalaryAccountInvalid() {
        String accountId = bank.createSalaryAccount(5000);
        assertNull(accountId);
    }

    @Test
    void testDeposit() {
        String accountId = bank.createSavingsAccount();
        assertTrue(bank.deposit(accountId, 1, 1000));
        assertEquals(1000, bank.getBalance(accountId));
    }

    @Test
    void testDepositInvalidAccount() {
        assertFalse(bank.deposit("invalid-id", 1, 1000));
    }

    @Test
    void testWithdraw() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 1, 1000);
        assertTrue(bank.withdraw(accountId, 2, 500));
        assertEquals(500, bank.getBalance(accountId));
    }

    @Test
    void testWithdrawInvalidAccount() {
        assertFalse(bank.withdraw("invalid-id", 1, 500));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 1, 1000);
        assertFalse(bank.withdraw(accountId, 2, 2000));
        assertEquals(1000, bank.getBalance(accountId));
    }

    @Test
    void testGetBalance() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 1, 1500);
        assertEquals(1500, bank.getBalance(accountId));
    }

    @Test
    void testGetBalanceInvalidAccount() {
        assertEquals(0, bank.getBalance("invalid-id"));
    }

    @Test
    void testPrintAccount() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 1, 2000);
        assertDoesNotThrow(() -> bank.print(accountId));
    }

    @Test
    void testPrintInvalidAccount() {
        assertDoesNotThrow(() -> bank.print("invalid-id"));
    }

    @Test
    void testPrintMonthlyAccount() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 360, 3000);
        assertDoesNotThrow(() -> bank.print(accountId, 1971, 1));
    }

    @Test
    void testGetBankBalance() {
        String account1 = bank.createSavingsAccount();
        String account2 = bank.createPromoYouthSavingsAccount();
        bank.deposit(account1, 1, 2000);
        bank.deposit(account2, 2, 3000);
        assertEquals(-5030, bank.getBalance());
    }
}
