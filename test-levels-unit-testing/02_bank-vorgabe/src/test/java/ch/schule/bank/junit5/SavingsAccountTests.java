package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTests {

	private SavingsAccount savingsAccount;

	@BeforeEach
	void setUp() {
		savingsAccount = new SavingsAccount("S-1000");
	}

	@Test
	void testWithdrawSufficientBalance() {
		savingsAccount.deposit(1, 5000);
		assertTrue(savingsAccount.withdraw(2, 3000));
		assertEquals(2000, savingsAccount.getBalance());
	}

	@Test
	void testWithdrawInsufficientBalance() {
		savingsAccount.deposit(1, 2000);
		assertFalse(savingsAccount.withdraw(2, 3000));
		assertEquals(2000, savingsAccount.getBalance());
	}

	@Test
	void testWithdrawNegativeAmount() {
		savingsAccount.deposit(1, 5000);
		assertFalse(savingsAccount.withdraw(2, -1000));
		assertEquals(5000, savingsAccount.getBalance());
	}

	@Test
	void testWithdrawZeroAmount() {
		savingsAccount.deposit(1, 5000);
		assertTrue(savingsAccount.withdraw(2, 0));
		assertEquals(5000, savingsAccount.getBalance());
	}

	@Test
	void testDeposit() {
		assertTrue(savingsAccount.deposit(1, 3000));
		assertEquals(3000, savingsAccount.getBalance());
	}

	@Test
	void testInheritance() {
		assertTrue(savingsAccount instanceof SavingsAccount);
		assertTrue(savingsAccount instanceof ch.schule.Account);
	}
}
