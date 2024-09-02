package healthcare.repository;

import healthcare.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PatientRepositoryImpl {

    private SessionFactory sessionfactory;

    public PatientRepositoryImpl(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    public void createPatient(Patient patient) {
         try(Session session = sessionfactory.openSession() ){
             Transaction transaction = session.beginTransaction();
             session.save(patient);
             transaction.commit();
         }

    }

    public Patient getPatientByID(int patientId){
        try(Session session = sessionfactory.openSession()){
           // Transaction transaction = session.beginTransaction();
            return session.get(Patient.class, patientId);
        }
    }

    public void updatePatient(Patient patient) {
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        }
    }

    public void deletePatientId(int patientId) {
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, patientId);
           if(patient != null){
               session.delete(patient);

           }
           transaction.commit();

        }
    }


public List<Patient> getAllPatients(){
       try(Session session = sessionfactory.openSession()) {
           return session.createQuery("from Patient",Patient.class).list();
       }
}


}
