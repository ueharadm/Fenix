package Fenix.Meeting;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
	@ManyToOne
	@JoinColumn(
			name = "member_id"
	)
	private Member worshipfulMaster;
	@Enumerated(EnumType.STRING)
	private MeetingType type;
	private LocalDate date;
	@ManyToMany
	@JoinTable(name = "member_meeting",
			joinColumns = { @JoinColumn(name = "meeting_id")},
			inverseJoinColumns = { @JoinColumn(name = "member_id")}
	)
	private Set<Member> attendees;
}
