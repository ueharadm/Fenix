package Fenix.Attendance;

import Fenix.Meeting.Meeting;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResponse {
    private Double attendanceRate;
    private long totalMeetings;
    private long totalAttendedMeetings;
    List<Meeting> attendedMeetings;
}
