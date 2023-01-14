package Fenix.Meeting;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
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
	@Enumerated(EnumType.STRING)
	private MeetingType type;
	private LocalDate date; 
	private Set<Integer> presentMemberIds;

	public Meeting( Integer number, MeetingType type, LocalDate date) {
		this.number = number;
		this.type = type;
		this.date = date;
		this.presentMemberIds = new LinkedHashSet<Integer>();
	}
}
