package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromoYouthSavingsAccountTests {

	private PromoYouthSavingsAccount promoYouthSavingsAccount;

	@BeforeEach
	void setUp() {
		promoYouthSavingsAccount = new PromoYouthSavingsAccount("Y-1000");
	}

	@Test
	void testDepositWithBonus() {
		assertTrue(promoYouthSavingsAccount.deposit(1, 1000));
		assertEquals(1010, promoYouthSavingsAccount.getBalance());
	}

	@Test
	void testDepositNegativeAmount() {
		assertFalse(promoYouthSavingsAccount.deposit(1, -1000));
		assertEquals(0, promoYouthSavingsAccount.getBalance());
	}

	@Test
	void testDepositZeroAmount() {
		assertTrue(promoYouthSavingsAccount.deposit(1, 0));
		assertEquals(0, promoYouthSavingsAccount.getBalance());
	}

	@Test
	void testInheritance() {
		assertTrue(promoYouthSavingsAccount instanceof PromoYouthSavingsAccount);
		assertTrue(promoYouthSavingsAccount instanceof ch.schule.SavingsAccount);
	}
}
