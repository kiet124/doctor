/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DoctorController;
import java.util.List;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author dotha
 */
public class DoctorView {
    private final DoctorController controller;
    private final Scanner scanner;

    public DoctorView() {
        this.controller = new DoctorController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    controller.saveData(); 
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addDoctor() {
        System.out.println("Adding a new doctor:");
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter availability: ");
        int availability = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        boolean success = controller.addDoctor(newDoctor);
        if (success) {
            System.out.println("Doctor added successfully.");
        } else {
            System.out.println("Failed to add doctor. Check if code is duplicate or input is invalid.");
        }
    }

    private void updateDoctor() {
        System.out.print("Enter code of the doctor to update: ");
        String code = scanner.nextLine();
        Doctor existingDoctor = controller.getDoctorByCode(code);

        if (existingDoctor == null) {
            System.out.println("Doctor with code " + code + " does not exist.");
            return;
        }

        System.out.println("Updating doctor: " + existingDoctor);
        System.out.print("Enter new name (or leave blank to keep existing): ");
        String newName = scanner.nextLine();
        System.out.print("Enter new specialization (or leave blank to keep existing): ");
        String newSpecialization = scanner.nextLine();
        System.out.print("Enter new availability (or -1 to keep existing): ");
        int newAvailability = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (!newName.isEmpty()) {
            existingDoctor.setName(newName);
        }

        if (!newSpecialization.isEmpty()) {
            existingDoctor.setSpecialization(newSpecialization);
        }

        if (newAvailability != -1) {
            existingDoctor.setAvailability(newAvailability);
        }

        boolean success = controller.updateDoctor(existingDoctor);
        if (success) {
            System.out.println("Doctor updated successfully.");
        } else {
            System.out.println("Failed to update doctor. Check if code is invalid.");
        }
    }

    private void deleteDoctor() {
        System.out.print("Enter code of the doctor to delete: ");
        String code = scanner.nextLine();
        boolean success = controller.deleteDoctor(code);
        if (success) {
            System.out.println("Doctor with code " + code + " has been deleted.");
        } else {
            System.out.println("Failed to delete doctor. Check if code is invalid.");
        }
    }

    private void searchDoctor() {
        System.out.print("Enter search string: ");
        String searchString = scanner.nextLine();
        List<Doctor> result = controller.searchDoctor(searchString);
        if (result.isEmpty()) {
            System.out.println("No doctors found matching the search criteria.");
        } else {
            System.out.println("Search results:");
            for (Doctor doctor : result) {
                System.out.println(doctor);
            }
        }
    }
}