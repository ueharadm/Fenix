package Fenix.Meeting;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import Fenix.Member.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
		name = "meeting",
		uniqueConstraints = {
		}
)
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Meeting {

	@Id
	@SequenceGenerator(
			name = "meeting_sequence",
			sequenceName = "meeting_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "meeting_sequence"
	)
	private Integer id;
	private Integer number;
	private Integer worshipfulMasterId;
	@Enumerated(EnumType.STRING)
	private MeetingType type;
	private LocalDate date;
	@ManyToMany
	@JoinTable(name = "member_meeting_table",
	joinColumns = {
			@JoinColumn(name = "member", referencedColumnName = "id")
	})
	private Set<Member> attendees;

	public Meeting( Integer number, Integer worshipfulMasterId, MeetingType type, LocalDate date) {
		this.number = number;
		this.worshipfulMasterId = worshipfulMasterId;
		this.type = type;
		this.date = date;
		this.attendees = new LinkedHashSet<Member>();
	}
}
