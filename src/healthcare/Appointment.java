package healthcare;

import java.util.Scanner;

public class Appointment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter patient name:");
        String patientName = sc.nextLine();

        System.out.println("Enter patient age:");
        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid age.");
            sc.close();
            return;
        }

        int patientAge = sc.nextInt();

        if (patientAge <= 0 || patientAge > 120) {
            System.out.println("Invalid patient age.");
            sc.close();
            return;
        }

        sc.nextLine();

        System.out.println("Available Doctors:");
        System.out.println("1. Dr. Smith - Cardiologist");
        System.out.println("2. Dr. Harsha - Neurologist");
        System.out.println("3. Dr. John - Dermatologist");

        System.out.println("Select a doctor:");

        if (!sc.hasNextInt()) {
            System.out.println("Please enter a doctor number.");
            sc.close();
            return;
        }

        int choice = sc.nextInt();
        sc.nextLine();

        String doctorName;

        if (choice == 1) {
            doctorName = "Dr. Smith";
        } else if (choice == 2) {
            doctorName = "Dr. Harsha";
        } else if (choice == 3) {
            doctorName = "Dr. John";
        } else {
            System.out.println("Invalid doctor selection");
            sc.close();
            return;
        }

        System.out.println("Enter appointment time:");
        String appointmentTime = sc.nextLine();

        System.out.println("Appointment Details");
        System.out.println("Patient: " + patientName);
        System.out.println("Age: " + patientAge);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Time: " + appointmentTime);

        System.out.println("Do you want to confirm your appointment?");
        System.out.println("1. Confirm");
        System.out.println("2. Cancel");

        int confirmation = sc.nextInt();

        if (confirmation == 1) {
            System.out.println("Appointment booked successfully!");
        } else if (confirmation == 2) {
            System.out.println("Appointment cancelled.");
        } else {
            System.out.println("Invalid option.");
        }  
        
        sc.close();
    }
}
