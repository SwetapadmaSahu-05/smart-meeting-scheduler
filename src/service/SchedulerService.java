package service;

import model.Meeting;
import util.FileHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SchedulerService {

    private ArrayList<Meeting> meetings;
    private Scanner scanner;

    public SchedulerService() {

        meetings = FileHandler.loadMeetings();
        scanner = new Scanner(System.in);
    }

    public void addMeeting() {

        System.out.println("\n===== ADD MEETING =====");

        System.out.print("Enter Meeting ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Meeting Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Time: ");
        String time = scanner.nextLine();

        for (Meeting meeting : meetings) {

            if (meeting.getDate().equals(date)
                    && meeting.getTime().equals(time)) {

                System.out.println(
                        "Meeting conflict detected!"
                );

                return;
            }
        }

        System.out.print(
                "Enter Priority (High/Medium/Low): "
        );

        String priority = scanner.nextLine();

        Meeting meeting = new Meeting(
                id,
                title,
                date,
                time,
                priority
        );

        meetings.add(meeting);

        FileHandler.saveMeetings(meetings);

        System.out.println(
                "Meeting added successfully!"
        );
    }

    public void viewMeetings() {

        System.out.println("\n===== MEETING LIST =====");

        if (meetings.isEmpty()) {

            System.out.println("No meetings found.");
            return;
        }

        for (Meeting meeting : meetings) {

            System.out.println("----------------------------");

            System.out.println(
                    "ID       : "
                            + meeting.getMeetingId());

            System.out.println(
                    "Title    : "
                            + meeting.getTitle());

            System.out.println(
                    "Date     : "
                            + meeting.getDate());

            System.out.println(
                    "Time     : "
                            + meeting.getTime());

            System.out.println(
                    "Priority : "
                            + meeting.getPriority());
        }
    }

    public void updateMeeting() {

        System.out.print(
                "\nEnter Meeting ID to update: "
        );

        int id = scanner.nextInt();
        scanner.nextLine();

        for (Meeting meeting : meetings) {

            if (meeting.getMeetingId() == id) {

                System.out.print(
                        "Enter New Time: "
                );

                String newTime =
                        scanner.nextLine();

                System.out.print(
                        "Enter New Priority: "
                );

                String newPriority =
                        scanner.nextLine();

                meeting.setTime(newTime);

                meeting.setPriority(newPriority);

                FileHandler.saveMeetings(meetings);

                System.out.println(
                        "Meeting updated successfully!"
                );

                return;
            }
        }

        System.out.println("Meeting not found.");
    }

    public void cancelMeeting() {

        System.out.print(
                "\nEnter Meeting ID to cancel: "
        );

        int id = scanner.nextInt();

        Iterator<Meeting> iterator =
                meetings.iterator();

        while (iterator.hasNext()) {

            Meeting meeting = iterator.next();

            if (meeting.getMeetingId() == id) {

                iterator.remove();

                FileHandler.saveMeetings(meetings);

                System.out.println(
                        "Meeting cancelled successfully!"
                );

                return;
            }
        }

        System.out.println("Meeting not found.");
    }

    public void searchMeeting() {

        scanner.nextLine();

        System.out.print(
                "\nEnter Meeting Title: "
        );

        String title = scanner.nextLine();

        for (Meeting meeting : meetings) {

            if (meeting.getTitle()
                    .equalsIgnoreCase(title)) {

                System.out.println(
                        "\nMeeting Found"
                );

                System.out.println(
                        "ID       : "
                                + meeting.getMeetingId());

                System.out.println(
                        "Date     : "
                                + meeting.getDate());

                System.out.println(
                        "Time     : "
                                + meeting.getTime());

                System.out.println(
                        "Priority : "
                                + meeting.getPriority());

                return;
            }
        }

        System.out.println("Meeting not found.");
    }
}