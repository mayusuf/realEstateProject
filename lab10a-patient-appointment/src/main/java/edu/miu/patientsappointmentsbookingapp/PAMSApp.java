package edu.miu.patientsappointmentsbookingapp;

import java.util.Arrays;
import java.util.Comparator;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.miu.patientsappointmentsbookingapp.model.Address;
import edu.miu.patientsappointmentsbookingapp.model.Patient;

@SpringBootApplication
public class PAMSApp {

	public static void main(String[] args) {
		SpringApplication.run(PAMSApp.class, args);
	}

	public static String getPatientsAsJson() {
		Patient[] patients = createPatients();
		sortByOldestPatientFirst(patients);

		return convertPatientsToJson(patients);
	}

	private static String convertPatientsToJson(Patient[] patients) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			return objectMapper.writeValueAsString(patients);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Unable to convert patients to JSON.", e);
		}
	}

	private static void sortByOldestPatientFirst(Patient[] patients) {
		Arrays.sort(patients, Comparator.comparing(Patient::getDateOfBirth));
	}

	private static Patient[] createPatients() {
		return new Patient[] {
			new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as",
					new Address("1 N Street", null, null, null), LocalDate.of(1987, 1, 19)),
			new Patient(2, "Ana", "Smith", null, "amsith@te.edu",
					null, LocalDate.of(1948, 12, 5)),
			new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null,
					new Address("4 East Ave", null, null, null), LocalDate.of(2001, 9, 18)),
			new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za",
					null, LocalDate.of(1995, 2, 28)),
			new Patient(5, "Mary", "Washington", null, null,
					new Address("30 W Burlington", null, null, null), LocalDate.of(1932, 5, 31))
		};
	}

}
