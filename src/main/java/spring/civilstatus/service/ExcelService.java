package spring.civilstatus.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.io.IOException;
import spring.civilstatus.models.Annexe;
import spring.civilstatus.repository.AnnexeRepository;
import spring.civilstatus.repository.RoleRepository;
import spring.civilstatus.repository.UserRepository;

@Service
public class ExcelService {
	@Autowired
	AnnexeRepository annexeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	public Map<String, String> readExcelFile(String path) {
		Map<String, String> emailRoleMap = new HashMap<>();

		try (Workbook workbook = new XSSFWorkbook(path)) {
			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				if (row.getCell(0) != null && row.getCell(1) != null && row.getCell(2) != null) {
					String email = row.getCell(0).getStringCellValue();
					String role = row.getCell(1).getStringCellValue();
					emailRoleMap.put(email, role);

					String lieuDeTravail = row.getCell(2).getStringCellValue();
					Annexe annexe = annexeRepository.findByName(lieuDeTravail);
					if (annexe == null) {
						annexe = new Annexe();
						annexe.setNomAnnexe(lieuDeTravail);
						annexeRepository.save(annexe);
					}
				}
			}
		} catch (IOException | java.io.IOException e) {
			e.printStackTrace();
		}

		return emailRoleMap;
	}

	public String getRoleFromExcel(String email, Map<String, String> emailRoleMap) {
		return emailRoleMap.get(email);
	}

	public String getLieuDeTravailFromExcel(String email, Map<String, String> emailRoleMap) {
		for (Map.Entry<String, String> entry : emailRoleMap.entrySet()) {
			if (entry.getKey().equals(email)) {
				String[] values = entry.getValue().split(",");
				if (values.length >= 3) {
					return values[2];
				}
			}
		}
		return null; 
	}
}