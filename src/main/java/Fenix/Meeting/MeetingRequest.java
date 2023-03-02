package Fenix.Meeting;

import Fenix.Member.Member;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class MeetingRequest {

    @Nonnull
    private Integer number;
    @Nonnull
    private Member worshipfulMaster;
    @Nonnull
    @Enumerated(EnumType.STRING)
    private MeetingType type;
    @Nonnull
    private LocalDate date;
    private HashSet<Member> attendees;
}
