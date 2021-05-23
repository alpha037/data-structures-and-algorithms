package AlgoExSolutions.VeryHard.CalendarMatching;

import java.util.*;

/**
 * * Calendar Matching
 */
class Program {
  /**
   * * TC: O(c1 + c2)
   * * SC: O(c1 + c2)
   */
  public static List<StringMeeting> calendarMatching(
      List<StringMeeting> calendar1,
      StringMeeting dailyBounds1,
      List<StringMeeting> calendar2,
      StringMeeting dailyBounds2,
      int meetingDuration) {
    // Write your code here.
    List<Integer[]> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
    List<Integer[]> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
    List<Integer[]> mergedCalendar =
        mergeCalendarsAndOverlappingIntervals(updatedCalendar1, updatedCalendar2);

    return getMatchingAvailabilities(mergedCalendar, meetingDuration);
  }

  private static List<Integer[]> updateCalendar(
      List<StringMeeting> calendar, StringMeeting dailyBounds) {
    List<StringMeeting> updatedCalendar = new ArrayList<>();
    updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
    updatedCalendar.addAll(calendar);
    updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));

    List<Integer[]> calendarInMins = new ArrayList<>();
    for (StringMeeting meeting : updatedCalendar)
      calendarInMins.add(new Integer[] {timeToMinutes(meeting.start), timeToMinutes(meeting.end)});
    return calendarInMins;
  }

  private static List<Integer[]> mergeCalendarsAndOverlappingIntervals(
      List<Integer[]> calendar1, List<Integer[]> calendar2) {
    List<Integer[]> mergedCalendar = new ArrayList<>();
    int i = 0, j = 0;
    while (i < calendar1.size() && j < calendar2.size()) {
      Integer[] meeting1 = calendar1.get(i), meeting2 = calendar2.get(j);
      if (meeting1[0] < meeting2[0]) {
        mergedCalendar.add(meeting1);
        ++i;
      } else {
        mergedCalendar.add(meeting2);
        ++j;
      }
    }

    while (i < calendar1.size()) mergedCalendar.add(calendar1.get(i++));
    while (j < calendar2.size()) mergedCalendar.add(calendar2.get(j++));

    return mergeOverlappingIntervals(mergedCalendar);
  }

  private static List<Integer[]> mergeOverlappingIntervals(List<Integer[]> calendar) {
    List<Integer[]> mergedIntervals = new ArrayList<>();
    mergedIntervals.add(calendar.get(0));

    for (int i = 1; i < calendar.size(); i++) {
      Integer[] current = calendar.get(i);
      Integer[] previous = mergedIntervals.get(mergedIntervals.size() - 1);
      if (previous[1] >= current[0]) {
        mergedIntervals.set(
            mergedIntervals.size() - 1,
            new Integer[] {previous[0], Math.max(previous[1], current[1])});
      } else mergedIntervals.add(current);
    }

    return mergedIntervals;
  }

  private static List<StringMeeting> getMatchingAvailabilities(
      List<Integer[]> calendar, int meetingDuration) {
    List<StringMeeting> matchingAvailabilities = new ArrayList<>();
    for (int i = 1; i < calendar.size(); i++) {
      int start = calendar.get(i - 1)[1], end = calendar.get(i)[0];
      if (end - start >= meetingDuration)
        matchingAvailabilities.add(new StringMeeting(minutesToTime(start), minutesToTime(end)));
    }

    return matchingAvailabilities;
  }

  private static int timeToMinutes(String meeting) {
    String[] intervals = meeting.split(":");
    int startTime = Integer.parseInt(intervals[0]);
    int endTime = Integer.parseInt(intervals[1]);
    return startTime * 60 + endTime;
  }

  private static String minutesToTime(int minutes) {
    int hours = minutes / 60, mins = minutes % 60;
    String hoursString = String.valueOf(hours);
    String minutesString = mins < 10 ? "0" + String.valueOf(mins) : String.valueOf(mins);
    return hoursString + ":" + minutesString;
  }

  static class StringMeeting {
    public String start;
    public String end;

    public StringMeeting(String start, String end) {
      this.start = start;
      this.end = end;
    }
  }
}
