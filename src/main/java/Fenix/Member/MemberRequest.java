package Fenix.Member;

import Fenix.Attendance.AttendanceRule;
import Fenix.Lodge.Lodge;
import Fenix.Meeting.Meeting;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class MemberRequest {
    @Nonnull
    private String name;
    @Nonnull
    private Long registration;
    @Nonnull
    @Enumerated(EnumType.STRING)
    private MemberDegree degree;
    private Integer lodgeId;
    @Nonnull
    private LocalDate birthDate;
    @Nonnull
    private LocalDate initiationDate;
    private AttendanceRule attendanceRule;
    private boolean isRedeemed;
}
