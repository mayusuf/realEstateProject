package edu.miu.patientsappointmentsbookingapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.miu.patientsappointmentsbookingapp.model.Address;
import edu.miu.patientsappointmentsbookingapp.model.Patient;

@Repository
public class PatientRepository {
	private final List<Patient> patients = new ArrayList<>();

	public Patient save(Patient patient) {
		patients.add(patient);
		return patient;
	}

	public List<Patient> findAll() {
		return new ArrayList<>(patients);
	}

	public Optional<Patient> findByEmail(String email) {
		for (Patient patient : patients) {
			if (equalsIgnoreCase(patient.getEmail(), email)) {
				return Optional.of(patient);
			}
		}

		return Optional.empty();
	}

	public List<Patient> findByCity(String city) {
		List<Patient> matchingPatients = new ArrayList<>();

		for (Patient patient : patients) {
			Address address = patient.getMailingAddress();

			if (address != null && equalsIgnoreCase(address.getCity(), city)) {
				matchingPatients.add(patient);
			}
		}

		return matchingPatients;
	}

	public List<Patient> findByState(String state) {
		List<Patient> matchingPatients = new ArrayList<>();

		for (Patient patient : patients) {
			Address address = patient.getMailingAddress();

			if (address != null && equalsIgnoreCase(address.getState(), state)) {
				matchingPatients.add(patient);
			}
		}

		return matchingPatients;
	}

	public List<Patient> findByZipCode(String zipCode) {
		List<Patient> matchingPatients = new ArrayList<>();

		for (Patient patient : patients) {
			Address address = patient.getMailingAddress();

			if (address != null && address.getZipCode() != null && address.getZipCode().equals(zipCode)) {
				matchingPatients.add(patient);
			}
		}

		return matchingPatients;
	}

	private boolean equalsIgnoreCase(String firstValue, String secondValue) {
		return firstValue != null && secondValue != null && firstValue.equalsIgnoreCase(secondValue);
	}

}
