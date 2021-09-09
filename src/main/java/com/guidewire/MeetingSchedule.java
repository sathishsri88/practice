package com.guidewire;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingSchedule {
    public int solution(String S) {
        final String[] lines = S.split("\n");
        List<Meeting> meetings = new ArrayList<>();
        for (String line : lines) {
            meetings.add(new Meeting(line));
        }
        // Group meetings by day of week
        final List<Meeting> freeTimeMeetings = Utils.getFreeTimeMeetings(meetings, 1);
        //
        final List<Meeting> finalFreeMeetingList = Utils.mergeOverlappingMeetings(freeTimeMeetings);
        final Meeting maxFreeTime = Utils.getMaxFreeTime(finalFreeMeetingList);
//        return maxFreeTime.duration
        return -1;
    }
}

class Meeting {
    final LocalTime startTime;
    final LocalTime endTime;
    final int dayOfWeek;
    final String stringRepresentation;
    private static final String SPACE = " ";
    private static final String HYPEN = "-";

    public Meeting(String stringRepresentation) {
        // Sun 10:00-20:00
        final String[] cols = stringRepresentation.trim().split(SPACE);
        if (cols.length != 2) {
            throw new IllegalArgumentException("Expected two columns for the incoming meeting datetime representation: "
                    + stringRepresentation);
        }
        final String[] times = cols[1].split(HYPEN);
        if (times.length != 2) {
            throw new IllegalArgumentException("Expected two columns for the incoming meeting time representation" +
                    "Ex[10:00-20:00] received: " + stringRepresentation);
        }
        this.startTime = LocalTime.parse(times[0]);
        this.endTime = LocalTime.parse(times[1]);
        this.dayOfWeek = DayOfWeek.dayOfWeek(cols[0]);
        this.stringRepresentation = stringRepresentation;
    }

    public Meeting(LocalTime startTime, LocalTime endTime, int dayOfWeek, String stringRepresentation) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.stringRepresentation = stringRepresentation;
    }
}

class Utils {
    public static Meeting getMaxFreeTime(List<Meeting> meetings) {
        Duration maxDuration = Duration.ofMillis(0);
        Meeting maxFreeTimeMeeting = null;
        for (Meeting meeting : meetings) {
            final Duration currentDuration = Duration.between(meeting.startTime, meeting.endTime);
            if (currentDuration.getSeconds() > maxDuration.getSeconds()) {
                maxDuration = currentDuration;
                maxFreeTimeMeeting = meeting;
            }
        }
        return maxFreeTimeMeeting;
    }

    public static List<Meeting> getFreeTimeMeetings(List<Meeting> meetings, int dayOfWeek) {
        LocalTime startTime = LocalTime.parse("00:00");
        List<Meeting> freetimeMeetings = new ArrayList<>();
        for (Meeting meeting : meetings) {
            final Duration currentDuration = Duration.between(startTime, meeting.startTime);
            if (currentDuration.getSeconds() > 0) {
                freetimeMeetings.add(new Meeting(startTime, meeting.startTime, dayOfWeek,
                        "FREE_TIME"));
            }
            startTime = meeting.endTime;
        }
        if (!Duration.between(startTime, LocalTime.MIDNIGHT).isZero()) {
            freetimeMeetings.add(new Meeting(startTime, LocalTime.MIDNIGHT, dayOfWeek,
                    "FREE_TIME"));
        }
        return freetimeMeetings;
    }

    public static List<Meeting> mergeOverlappingMeetings(List<Meeting> meetings) {
        return null;
    }
}

enum DayOfWeek {
    SUN {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 7 : -1;
        }
    }, MON {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 1 : -1;
        }
    }, TUE {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 2 : -1;
        }
    }, WED {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 3 : -1;
        }
    }, THU {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 4 : -1;
        }
    }, FRI {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 5 : -1;
        }
    }, SAT {
        @Override
        int getDayOfWeek(String day) {
            // to avoid string mismatch
            return this.toString().equalsIgnoreCase(day) ? 6 : -1;
        }
    };

    abstract int getDayOfWeek(String day);

    public static int dayOfWeek(String day) {
        for (DayOfWeek dayOfWeek : values()) {
            final int dow = dayOfWeek.getDayOfWeek(day);
            if (dow > 0) {
                return dow;
            } else {
                throw new IllegalArgumentException("Received an un parsable Day String: " + day);
            }
        }
        return -1;
    }
}
