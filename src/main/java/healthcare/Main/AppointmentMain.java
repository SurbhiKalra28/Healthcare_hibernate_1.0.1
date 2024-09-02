package healthcare.Main;

import healthcare.model.Appointment;
import healthcare.model.Patient;
import healthcare.repository.AppointmentRepositoryImpl;
import healthcare.service.AppointmentService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AppointmentMain {
    public static void manageAppointment() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl(sessionFactory);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {

            do {
                System.out.println("1. Create Appointment");
                System.out.println("2. Read Appointment");
                System.out.println("3. Update Appointment");
                System.out.println("4. Delete Appointment");
                System.out.println("5. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();


                switch (choice) {
                    case 1:
                        Appointment newAppointment = new Appointment();
                        System.out.println("Enter Patient Id");
                        newAppointment.setPatientId(scanner.nextInt());
                        System.out.println("Enter Doctor Id");
                        newAppointment.setDoctorId(scanner.nextInt());
                        System.out.println("Enter Appointment Date");
                        newAppointment.setAppointmentDate(scanner.next());
                        System.out.println("Enter Notes");
                        newAppointment.setNotes(scanner.next());
                        appointmentService.createAppointment(newAppointment);
                        System.out.println("Appointment created");
                        break;

                    case 2:
                        System.out.println("Enter Appointment Id");
                        int appointmentId = scanner.nextInt();
                        scanner.nextLine();
                        Appointment appointment = new Appointment();
                        appointment = appointmentService.getAppointmentById(appointmentId);
                        if (appointment != null) {
                            System.out.println("Appointment ID: " + appointment.getAppointmentId());
                            System.out.println("Patient ID: " + appointment.getPatientId());
                            System.out.println("Doctor ID: " + appointment.getDoctorId());
                            System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                            System.out.println("Notes: " + appointment.getNotes());


                        } else {
                            System.out.println("Appointment ID: " + appointmentId + " Not Found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Appointment Id");
                        appointmentId = scanner.nextInt();
                        scanner.nextLine();
                        appointment = appointmentService.getAppointmentById(appointmentId);
                        if (appointment != null) {
                            System.out.println("Enter Patient ID:");
                            appointment.setPatientId(scanner.nextInt());
                            System.out.println("Enter Doctor ID:");
                            appointment.setDoctorId(scanner.nextInt());
                            System.out.println("Enter Appointment Date:");
                            appointment.setAppointmentDate(scanner.next());
                            System.out.println("Enter Notes:");
                            appointment.setNotes(scanner.next());
                            appointmentService.updateAppointment(appointment);
                            System.out.println("Appointment updated Successfully");

                        } else {
                            System.out.println("Appointment ID: " + appointmentId + " Not Found");

                        }
                        break;
                    case 4:
                        System.out.println("Enter Appointment Id");
                        appointmentId = scanner.nextInt();
                        scanner.nextLine();
                        appointmentService.deleteAppointment(appointmentId);
                        System.out.println("Appointment deleted Successfully");
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
