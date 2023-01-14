package Fenix.Lodge;

import jakarta.persistence.*;
import lombok.*;

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
}
