package Fenix.Meeting;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@NoArgsConstructor
public class Meeting {

	@Id
	private Integer meetingUid;
	private MeetingType type;
	private LocalDate date; 
	private Set<Integer> presentMemberIds = new LinkedHashSet<Integer>();
	public Meeting(Integer meetingUid, MeetingType type, LocalDate date) {
		super();
		this.meetingUid = meetingUid;
		this.type = type;
		this.date = date;
	}
	
	
	
}
