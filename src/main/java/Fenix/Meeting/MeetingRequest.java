package Fenix.Meeting;

import Fenix.Member.Member;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Getter
public class MeetingRequest {

    private Integer number;
    private Integer worshipfulMasterId;
    @Enumerated(EnumType.STRING)
    private MeetingType type;
    private LocalDate date;
    private Set<Member> attendees;
}
