package healthcare.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AppointmentId")
    int appointmentId;
    @Column(name = "PatientId")
    int patientId;
    @Column(name = "DoctorId")
    int doctorId;
    @Column(name = "AppointmentDate")
    String appointmentDate;
    @Column(name = "Notes")
    String notes;

    public Appointment(int patientId, int doctorId, String appointmentDate, String notes) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.notes = notes;
    }

    public Appointment() {
    }

}
