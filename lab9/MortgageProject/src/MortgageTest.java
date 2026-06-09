import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class MortgageTest {

	private MortgageCalculator calculator;

	@Before
	public void setUp() {
		calculator = new MortgageCalculator(LocalDate.of(2020, 1, 1));
	}

	@Test
	public void shouldCalculateMortgageForSingleArchitectWithMediumIncome() {
		double result = calculator.computeMaxMortgage(1967, 5, 2, 3000, false, 0, "Architect");

		assertEquals(180000, result, 0.001);
	}

	@Test
	public void shouldNotCalculateMortgageWhenApplicantIsNotOlderThanMinimumAge() {
		double result = calculator.computeMaxMortgage(2001, 5, 2, 3000, false, 0, "Architect");

		assertEquals(0, result, 0.001);
	}

	@Test
	public void shouldIncludePartnerIncomeForMarriedApplicant() {
		double result = calculator.computeMaxMortgage(1977, 12, 2, 4000, true, 2000, "Developer");

		assertEquals(220000, result, 0.001);
	}

	@Test
	public void shouldCalculateMortgageForProfessorWithHighIncome() {
		double result = calculator.computeMaxMortgage(1954, 5, 12, 5500, false, 0, "Professor");

		assertEquals(280000, result, 0.001);
	}

}
