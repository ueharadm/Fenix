package Fenix.Member;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberRequest {
    private String name;
    private Long registration;
    @Enumerated(EnumType.STRING)
    private MemberDegree degree;
    private Integer lodge;
    private LocalDate birthDate;
    private LocalDate initiationDate;
}