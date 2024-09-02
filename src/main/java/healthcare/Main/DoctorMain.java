package healthcare.Main;

import healthcare.model.Doctor;
import healthcare.model.Patient;
import healthcare.repository.DoctorRepositoryImpl;
import healthcare.service.DoctorService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DoctorMain {
    public static void manageDoctor() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepository);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;


        try {

            do {
                System.out.println("1. Create Doctor");
                System.out.println("2. Read Doctor");
                System.out.println("3. Update Doctor");
                System.out.println("4. Delete Doctor");
                System.out.println("5. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();


                switch (choice) {
                    case 1:
                        Doctor newDoctor = new Doctor();

                        System.out.println("Enter Doctor First Name");
                        newDoctor.setFirstName(scanner.nextLine());
                        System.out.println("Enter Doctor Last Name");
                        newDoctor.setLastName(scanner.nextLine());
                        System.out.println("Enter Doctor Email");
                        newDoctor.setEmail(scanner.nextLine());
                        System.out.println("Enter Doctor's specialization");
                        newDoctor.setSpeciality(scanner.nextLine());
                        doctorService.createDoctor(newDoctor);
                        System.out.println("Doctor created Successfully");
                        break;

                    case 2:
                        int doctorID;

                        System.out.println("Enter Doctor ID");
                        doctorID = scanner.nextInt();
                        scanner.nextLine();
                        Doctor doctor = doctorService.getDoctorById(doctorID);
                        if (doctor != null) {
                            System.out.println("Doctor ID: " + doctor.getDoctorId());
                            System.out.println("Doctor First Name: " + doctor.getFirstName());
                            System.out.println("Doctor Last Name: " + doctor.getLastName());
                            System.out.println("Doctor Email: " + doctor.getEmail());
                            System.out.println("Doctor's specialization: " + doctor.getSpeciality());
                        } else {
                            System.out.println("Doctor not found");
                        }
                        break;


                    case 3:
                        System.out.println("Enter Doctor ID");
                        doctorID = scanner.nextInt();
                        scanner.nextLine();
                        doctor = doctorService.getDoctorById(doctorID);
                        if (doctor != null) {
                            System.out.println("Enter Patient First Name:");
                            doctor.setFirstName(scanner.nextLine());
                            System.out.println("Enter Patient Last Name:");
                            doctor.setLastName(scanner.nextLine());
                            System.out.println("Enter Patient Email:");
                            doctor.setEmail(scanner.nextLine());
                            System.out.println("Enter Patient Specialization:");
                            doctor.setSpeciality(scanner.nextLine());
                            doctorService.updateDoctor(doctor);
                            System.out.println("Doctor updated Successfully");

                        } else {
                            System.out.println("Doctor not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Doctor ID");
                        doctorID = scanner.nextInt();
                        scanner.nextLine();
                        doctorService.deleteDoctor(doctorID);
                        System.out.println("Doctor deleted Successfully");
                }
            } while (choice != 5);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        sessionFactory.close();
    }
}

