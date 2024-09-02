package healthcare.service;

import healthcare.model.Doctor;
import healthcare.repository.DoctorRepositoryImpl;

import java.util.List;

public class DoctorService {

    public final DoctorRepositoryImpl doctorRepository;
    public DoctorService(DoctorRepositoryImpl doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void createDoctor(Doctor doctor) {
        doctorRepository.createDoctor(doctor);
    }
    public Doctor getDoctorById(int doctorId) {
       return  doctorRepository.getDoctorById(doctorId);
    }
    public void updateDoctor(Doctor doctor){
        doctorRepository.updateDoctor(doctor);
    }
    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteDoctor(doctorId);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

}
