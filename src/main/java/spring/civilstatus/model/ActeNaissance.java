package spring.civilstatus.model;

import java.time.LocalDate;
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
public class ActeNaissance {
	private int id;
	private String typeEnregistrement;
	private LocalDate dateEnregistrement;
	private String lieuEnregistrement;
	private String nouveauNe;
	private String typeNaissance;
	private String declarant;
	private String relationAvecNouveauNe;
	
}
