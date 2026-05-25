package util;

import model.Meeting;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_PATH =
            "src/data/meetings.txt";

    public static void saveMeetings(
            ArrayList<Meeting> meetings) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_PATH)
                    );

            for (Meeting meeting : meetings) {

                writer.write(meeting.toString());

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving meetings."
            );
        }
    }

    public static ArrayList<Meeting> loadMeetings() {

        ArrayList<Meeting> meetings =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                meetings.add(
                        new Meeting(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                data[3],
                                data[4]
                        )
                );
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "No previous meetings found."
            );
        }

        return meetings;
    }
}