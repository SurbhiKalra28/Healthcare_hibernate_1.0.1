package healthcare.repository;

import healthcare.model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentRepositoryImpl {

    public SessionFactory sessionFactory;

    public AppointmentRepositoryImpl() {
    }

    public AppointmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAppointment(Appointment appointment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transcation = session.beginTransaction();
            session.save(appointment);
            transcation.commit();
        }
    }

    public Appointment getAppointmnetByID(int appointmentID) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Appointment.class, appointmentID);
        }
    }

    public void updateAppointment(Appointment appointment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
        }
    }

    public void deleteAppointment(int appointmentID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, appointmentID);
            if (appointment != null) {
                session.delete(appointment);
            }

            transaction.commit();
        }
    }

    public List<Appointment> getAllAppointments() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Appointment", Appointment.class).list();
        }
    }
}
