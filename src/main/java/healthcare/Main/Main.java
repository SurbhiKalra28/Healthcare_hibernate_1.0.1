package healthcare.Main;

import healthcare.model.Patient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        try{


        do {
            System.out.println("Please enter your choice");
            System.out.println("--- MAIN MENU ---");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    PatientMain.managePatient();
                    break;
                case 2:
                    DoctorMain.manageDoctor();
                    break;
                case 3:
                    AppointmentMain.manageAppointment();
                    break;
                case 4:
                    System.out.println("Thank you for using Healthcare");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


}
