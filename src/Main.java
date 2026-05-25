import service.AuthService;
import service.SchedulerService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AuthService authService = new AuthService();

        System.out.println("==================================");
        System.out.println("     SMART MEETING SCHEDULER");
        System.out.println("==================================");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean isValid =
                authService.login(username, password);

        if (!isValid) {

            System.out.println("\nInvalid Login!");
            return;
        }

        System.out.println("\nLogin Successful!");

        SchedulerService schedulerService =
                new SchedulerService();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("1. Add Meeting");
            System.out.println("2. View Meetings");
            System.out.println("3. Update Meeting");
            System.out.println("4. Cancel Meeting");
            System.out.println("5. Search Meeting");
            System.out.println("6. Exit");

            System.out.print("\nEnter Choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    schedulerService.addMeeting();
                    break;

                case 2:
                    schedulerService.viewMeetings();
                    break;

                case 3:
                    schedulerService.updateMeeting();
                    break;

                case 4:
                    schedulerService.cancelMeeting();
                    break;

                case 5:
                    schedulerService.searchMeeting();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        scanner.close();
    }
}