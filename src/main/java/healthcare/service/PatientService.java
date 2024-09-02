package healthcare.service;

import healthcare.model.Patient;
import healthcare.repository.PatientRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;

public class PatientService {

    public final PatientRepositoryImpl patientRepository;

    public PatientService(PatientRepositoryImpl patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void createPatient(Patient patient) {
        patientRepository.createPatient(patient);
    }

    public Patient getPatientById(int patientId) {
        return patientRepository.getPatientByID(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    public void updatePatient(Patient patient) {
        patientRepository.updatePatient(patient);
    }

    public void deletePatient(int patientId) {
        patientRepository.deletePatientId(patientId);
    }
}
