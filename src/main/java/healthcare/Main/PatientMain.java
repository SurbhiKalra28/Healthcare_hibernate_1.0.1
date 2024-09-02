package healthcare.Main;

import healthcare.model.Patient;
import healthcare.repository.PatientRepositoryImpl;
import healthcare.service.PatientService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class PatientMain {
    public static void managePatient() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(sessionFactory);
        PatientService patientService = new PatientService(patientRepository);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;


        try {

            do {
                System.out.println("1. Create Patient");
                System.out.println("2. Read Patient");
                System.out.println("3. Update Patient");
                System.out.println("4. Delete Patient");
                System.out.println("5. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();


                switch (choice) {
                    case 1:
                        Patient newPatient = new Patient();
                        System.out.println("Enter First Name: ");
                        newPatient.setFirstName(scanner.nextLine());
                        System.out.println("Enter Last Name: ");
                        newPatient.setLastName(scanner.nextLine());
                        System.out.println("Enter date of birth (YYY-MM-DD): ");
                        newPatient.setDateOfBirth(scanner.nextLine());
                        System.out.println("Enter Email: ");
                        newPatient.setEmail(scanner.nextLine());
                        System.out.println("Enter Phone Number: ");
                        newPatient.setPhoneNumber(scanner.nextLine());
                        patientService.createPatient(newPatient);
                        System.out.println("Patient created successfully");
                        break;
                    case 2:
                        System.out.println("Enter Patient ID: ");
                        int patientId = scanner.nextInt();
                        scanner.nextLine();
                        Patient patient = patientService.getPatientById(patientId);
                        if (patient != null) {
                            System.out.println("Patient ID: " + patient.getPatientId());
                            System.out.println("First Name: " + patient.getFirstName());
                            System.out.println("Last Name: " + patient.getLastName());
                            System.out.println("Date of birth: " + patient.getDateOfBirth());
                            System.out.println("Email: " + patient.getEmail());
                            System.out.println("Phone Number: " + patient.getPhoneNumber());
                        } else {
                            System.out.println("Patient not found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Patient ID: ");
                        int updatePatient = scanner.nextInt();
                        scanner.nextLine();
                        patient = patientService.getPatientById(updatePatient);
                        if (patient != null) {
                            System.out.println("Enter Patient First Name:");
                            patient.setFirstName(scanner.nextLine());
                            System.out.println("Enter Patient Last Name:");
                            patient.setLastName(scanner.nextLine());
                            System.out.println("Enter Patient Date of birth:");
                            patient.setDateOfBirth(scanner.nextLine());
                            System.out.println("Enter Patient Email:");
                            patient.setEmail(scanner.nextLine());
                            System.out.println("Enter Patient Phone Number:");
                            patient.setPhoneNumber(scanner.nextLine());
                            patientService.updatePatient(patient);
                            System.out.println("Patient updated successfully");
                        } else {
                            System.out.println("Patient not found");
                        }
                        break;

                    case 4:
                        System.out.println("Enter Patient ID: ");
                        int deletePatient = scanner.nextInt();
                        scanner.nextLine();
                        patientService.deletePatient(deletePatient);
                        System.out.println("Patient deleted successfully");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 5);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        sessionFactory.close();
    }
}
