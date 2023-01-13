package Fenix.Lodge;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@NoArgsConstructor
public class Lodge {
	@Id
	private Integer lodgeId;
	private String lodgeName;
}
