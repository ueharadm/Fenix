package Fenix.Attendance;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AttendanceRateRequest {

    private Integer memberId;
    private LocalDate initDate;
    private LocalDate finalDate;
    private AttendanceRule rule;
}
