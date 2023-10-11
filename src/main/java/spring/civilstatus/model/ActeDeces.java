package spring.civilstatus.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActeDeces {
	private int id;
	private String typeEnregistrement;
	private LocalDate dateEnregistrement;
	private String lieuEnregistrement;
	private String defunt;
	private String causeDeces;
	private LocalDate dateDeces;
	private LocalTime heureDeces;
	private String lieuDeces;
	private String declarant;
	private String relationAvecDefunt;
	private String conjoint;
}
