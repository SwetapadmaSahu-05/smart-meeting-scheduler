package model;

public class Meeting {

    private int meetingId;
    private String title;
    private String date;
    private String time;
    private String priority;

    public Meeting(int meetingId,
                   String title,
                   String date,
                   String time,
                   String priority) {

        this.meetingId = meetingId;
        this.title = title;
        this.date = date;
        this.time = time;
        this.priority = priority;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPriority() {
        return priority;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {

        return meetingId + "," +
                title + "," +
                date + "," +
                time + "," +
                priority;
    }
}