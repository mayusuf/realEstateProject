import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {

	private static final int MINIMUM_AGE = 18;
	private static final double MINIMUM_INCOME = 2000;
	private static final double MEDIUM_INCOME = 3000;
	private static final double HIGH_INCOME = 5000;
	private static final double PARTNER_INCOME_PERCENTAGE = 0.94;

	private static final int TECHNICAL_PROFESSION = 0;
	private static final int SUPPORT_PROFESSION = 1;
	private static final int LEADERSHIP_PROFESSION = 2;

	private static final double[][] MORTGAGE_LIMITS = {
		{ 160000, 120000, 220000 },
		{ 180000, 140000, 250000 },
		{ 220000, 160000, 280000 }
	};

	private final LocalDate calculationDate;

	public MortgageCalculator() {
		this(LocalDate.now());
	}

	public MortgageCalculator(LocalDate calculationDate) {
		this.calculationDate = calculationDate;
	}

	public double computeMaxMortgage(int yearOfBirth, int month, int day, double monthlyIncome,
			boolean married, double monthlyIncomePartner, String profession) {
		LocalDate birthDate = LocalDate.of(yearOfBirth, month, day);
		int age = calculateAge(birthDate);
		double income = calculateEligibleIncome(monthlyIncome, married, monthlyIncomePartner);

		if (age <= MINIMUM_AGE || income < MINIMUM_INCOME) {
			return 0;
		}

		int incomeLevel = getIncomeLevel(income);
		int professionLevel = getProfessionLevel(profession);

		if (professionLevel == -1) {
			return 0;
		}

		return MORTGAGE_LIMITS[incomeLevel][professionLevel];
	}

	private int calculateAge(LocalDate birthDate) {
		return Period.between(birthDate, calculationDate).getYears();
	}

	private double calculateEligibleIncome(double monthlyIncome, boolean married, double monthlyIncomePartner) {
		if (!married) {
			return monthlyIncome;
		}

		return monthlyIncome + monthlyIncomePartner * PARTNER_INCOME_PERCENTAGE;
	}

	private int getIncomeLevel(double income) {
		if (income < MEDIUM_INCOME) {
			return 0;
		}
		if (income < HIGH_INCOME) {
			return 1;
		}

		return 2;
	}

	private int getProfessionLevel(String profession) {
		if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) {
			return TECHNICAL_PROFESSION;
		}
		if (profession.equals("Tester") || profession.equals("System Administrator")
				|| profession.equals("Technical writer")) {
			return SUPPORT_PROFESSION;
		}
		if (profession.equals("Department head") || profession.equals("Professor")) {
			return LEADERSHIP_PROFESSION;
		}

		return -1;
	}

}
