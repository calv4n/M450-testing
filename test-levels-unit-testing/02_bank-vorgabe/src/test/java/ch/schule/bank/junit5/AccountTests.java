package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTests {

    private Account account;

    static class TestAccount extends Account {
        public TestAccount(String id) {
            super(id);
        }
    }

    @BeforeEach
    void setUp() {
        account = new TestAccount("TestAccount123");
    }

    @Test
    void testInit() {
        assertEquals("TestAccount123", account.getId());
        assertEquals(0, account.getBalance());
    }

    @Test
    void testDepositSuccess() {
        assertTrue(account.deposit(1, 1000));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        assertFalse(account.deposit(1, -1000));
        assertEquals(0, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        account.deposit(1, 1000);
        assertTrue(account.withdraw(2, 500));
        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(1, 500);
        assertTrue(account.withdraw(2, 1000));
        assertEquals(-500, account.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {
        account.deposit(1, 1000);
        assertFalse(account.withdraw(2, -500));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testCanTransact() {
        assertTrue(account.canTransact(1));
        account.deposit(1, 1000);
        assertFalse(account.canTransact(0));
        assertTrue(account.canTransact(2));
    }

    @Test
    void testPrint() {
        account.deposit(1, 1000);
        account.withdraw(2, 500);

        // Aufruf der Methode ohne Parameter
        assertDoesNotThrow(() -> account.print());
    }

    @Test
    void testMonthlyPrint() {
        account.deposit(360, 1000);
        account.withdraw(390, 500);

        assertDoesNotThrow(() -> account.print(1971, 1));
        assertDoesNotThrow(() -> account.print(1971, 2));
    }

    @Test
    void testGetBooking() {
        Booking booking = new Booking(1, 1000);
        account.setBooking(booking);
        assertEquals(booking, account.getBooking());
    }
}
