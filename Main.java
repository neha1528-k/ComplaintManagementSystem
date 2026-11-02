package com.complaintmanagement;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComplaintManager manager = new ComplaintManager();
        ComplaintService service = manager.getService();

        int choice;

        do {
            System.out.println("\n===== COMPLAINT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Search Complaint");
            System.out.println("4. Sort Complaints");
            System.out.println("5. Save Complaints");
            System.out.println("6. Load Complaints");
            System.out.println("7. Concurrency Demo");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        if (service.searchComplaint(id) != null) {
                            System.out.println("ID already exists!");
                            break;
                        }

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Description: ");
                        String description = sc.nextLine();

                        System.out.print("Enter Category: ");
                        String category = sc.nextLine();

                        TechnicalComplaint complaint =
                                new TechnicalComplaint(
                                        id, name, description, category);

                        service.addComplaint(complaint);

                        System.out.println("Complaint added!");
                        break;

                    case 2:
                        List<Complaint> list =
                                service.getAllComplaints();

                        if (list.isEmpty()) {
                            System.out.println("No complaints found.");
                        } else {
                            for (Complaint c : list) {
                                System.out.println(c);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Complaint ID: ");
                        int searchId =
                                Integer.parseInt(sc.nextLine());

                        Complaint found =
                                service.searchComplaint(searchId);

                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Complaint not found.");
                        }
                        break;

                    case 4:
                        service.sortComplaints();
                        System.out.println("Complaints sorted!");
                        break;

                    case 5:
                        manager.save();
                        break;

                    case 6:
                        manager.load();
                        break;

                    case 7:
                        manager.concurrencyDemo();
                        break;

                    case 8:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 8);

        manager.close();
        sc.close();
    }
}
