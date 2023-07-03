package Fenix.Member;

import Fenix.Attendance.AttendanceRule;
import Fenix.Lodge.Lodge;
import Fenix.Meeting.Meeting;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Member {

	@Id
	@SequenceGenerator(
			name = "member_sequence",
			sequenceName = "member_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "member_sequence"
	)
	private Integer id;
	private String name;
	private Long registration;
	@Enumerated(EnumType.STRING)
	private MemberDegree degree;
	@ManyToOne
	@JoinColumn(name = "lodge_id")
	private Lodge lodge;
	private LocalDate birthDate;
	private LocalDate initiationDate;
	private boolean isRedeemed;
	private AttendanceRule attendanceRule;
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(mappedBy = "attendees")
	private List<Meeting> attendedMeetings;


	public Member(String name, Long registration, MemberDegree degree, LocalDate birthDate, LocalDate initiationDate, boolean isRedeemed) {
		this.name = name;
		this.registration = registration;
		this.degree = degree;
		this.birthDate = birthDate;
		this.initiationDate = initiationDate;
		this.isRedeemed = isRedeemed();
	}
}

