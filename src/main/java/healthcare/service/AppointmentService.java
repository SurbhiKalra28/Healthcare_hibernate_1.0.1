package healthcare.service;

import healthcare.model.Appointment;
import healthcare.repository.AppointmentRepositoryImpl;

import java.util.List;

public class AppointmentService {

    public final AppointmentRepositoryImpl appointmentRepository;

    public AppointmentService(AppointmentRepositoryImpl appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.createAppointment(appointment);
    }

    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.getAppointmnetByID(appointmentId);
    }

    public void updateAppointment(Appointment appointment) {
        appointmentRepository.updateAppointment(appointment);
    }

    public void deleteAppointment(int appointmentId) {
        appointmentRepository.deleteAppointment(appointmentId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }


}
