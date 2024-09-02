package healthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoctorId")
    int doctorId;

    @Column(name = "FirstName")
    String firstName;
    @Column(name = "LastName")
    String lastName;
    @Column(name = "Speciality")
    String speciality;
    @Column(name = "Email")
    String email;

    public Doctor(int doctorId, String firstName, String lastName, String speciality, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.email = email;
    }

    public Doctor() {
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getEmail() {
        return email;
    }


}

