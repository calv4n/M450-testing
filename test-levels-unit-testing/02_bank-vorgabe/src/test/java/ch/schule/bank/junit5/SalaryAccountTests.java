package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryAccountTests {

	private SalaryAccount salaryAccount;

	@BeforeEach
	void setUp() {
		salaryAccount = new SalaryAccount("P-1000", -5000);
	}

	@Test
	void testWithdrawWithinCreditLimit() {
		salaryAccount.deposit(1, 10000);
		assertTrue(salaryAccount.withdraw(2, 12000));
		assertEquals(-2000, salaryAccount.getBalance());
	}

	@Test
	void testWithdrawExceedsCreditLimit() {
		salaryAccount.deposit(1, 10000);
		assertFalse(salaryAccount.withdraw(2, 16000));
		assertEquals(10000, salaryAccount.getBalance());
	}

	@Test
	void testWithdrawNegativeAmount() {
		assertFalse(salaryAccount.withdraw(1, -1000));
		assertEquals(0, salaryAccount.getBalance());
	}

	@Test
	void testWithdrawZeroAmount() {
		assertTrue(salaryAccount.withdraw(1, 0));
		assertEquals(0, salaryAccount.getBalance());
	}

	@Test
	void testDeposit() {
		assertTrue(salaryAccount.deposit(1, 5000));
		assertEquals(5000, salaryAccount.getBalance());
	}

	@Test
	void testInheritance() {
		assertTrue(salaryAccount instanceof SalaryAccount);
		assertTrue(salaryAccount instanceof ch.schule.Account);
	}
}
