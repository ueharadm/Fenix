package Fenix.Lodge;

import Fenix.Member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Lodge {
	@Id
	@SequenceGenerator(
			name = "lodge_sequence",
			sequenceName = "lodge_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "lodge_sequence"
	)
	private Integer id;
	private String name;
	private Integer register;
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "lodge")
	private List<Member> members;
}
