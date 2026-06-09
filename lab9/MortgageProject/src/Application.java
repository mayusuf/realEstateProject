
public class Application {

	public static void main(String[] args) {
		MortgageCalculator calculator = new MortgageCalculator();
		double maxMortgage = calculator.computeMaxMortgage(1967, 5, 2, 3000, false, 0, "Architect");

		System.out.println("Maximum mortgage: " + maxMortgage);
	}

}
