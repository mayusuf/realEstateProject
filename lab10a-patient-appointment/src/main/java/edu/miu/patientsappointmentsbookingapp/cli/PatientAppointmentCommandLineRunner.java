package edu.miu.patientsappointmentsbookingapp.cli;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import edu.miu.patientsappointmentsbookingapp.PAMSApp;

@Component
@Profile("!test")
public class PatientAppointmentCommandLineRunner implements CommandLineRunner {

	private static final String SHOW_DATA_OPTION = "1";
	private static final String EXIT_OPTION = "2";

	@Override
	public void run(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String selectedOption;

			do {
				printMenu();
				selectedOption = scanner.nextLine().trim();
				handleOption(selectedOption);
			} while (!EXIT_OPTION.equals(selectedOption));
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("Patients Appointments Booking App");
		System.out.println("1. Show data");
		System.out.println("2. Exit");
		System.out.print("Choose an option: ");
	}

	private void handleOption(String selectedOption) {
		switch (selectedOption) {
			case SHOW_DATA_OPTION:
				System.out.println(PAMSApp.getPatientsAsJson());
				break;
			case EXIT_OPTION:
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
		}
	}

}
