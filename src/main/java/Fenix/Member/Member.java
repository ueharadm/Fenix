package Fenix.Member;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
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
	private Integer lodge;
	private LocalDate birthDate;
	private LocalDate initiationDate;
	private boolean isRedeemed;


	public Member(String name, Long registration, MemberDegree degree, Integer lodge, LocalDate birthDate, LocalDate initiationDate, boolean isRedeemed) {
		this.name = name;
		this.registration = registration;
		this.degree = degree;
		this.lodge = lodge;
		this.birthDate = birthDate;
		this.initiationDate = initiationDate;
		this.isRedeemed = isRedeemed();
	}
}

