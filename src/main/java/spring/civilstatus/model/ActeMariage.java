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
public class ActeMariage {
	private int id;
	private String typeEnregistrement;
	private LocalDate dateEnregistrement;
	private String lieuEnregistrement;
	private String lieuMariage;
	private LocalDate dateMariage;
	private String Epouse;
	private String Epoux;
	private String mereEpouse;
	private String pereEpouse;
	private String mereEpoux;
	private String pereEpoux;
}
