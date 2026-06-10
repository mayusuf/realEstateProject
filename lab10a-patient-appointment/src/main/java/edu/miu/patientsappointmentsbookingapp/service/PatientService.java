package edu.miu.patientsappointmentsbookingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.miu.patientsappointmentsbookingapp.model.Patient;
import edu.miu.patientsappointmentsbookingapp.repository.PatientRepository;

@Service
public class PatientService {
	private final PatientRepository patientRepository;

	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public Patient registerPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Optional<Patient> findPatientByEmail(String email) {
		return patientRepository.findByEmail(email);
	}

	public List<Patient> findPatientsByCity(String city) {
		return patientRepository.findByCity(city);
	}

	public List<Patient> findPatientsByState(String state) {
		return patientRepository.findByState(state);
	}

	public List<Patient> findPatientsByZipCode(String zipCode) {
		return patientRepository.findByZipCode(zipCode);
	}

}
