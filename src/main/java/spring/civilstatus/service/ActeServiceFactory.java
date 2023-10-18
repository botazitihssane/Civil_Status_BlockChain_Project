package spring.civilstatus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.civilstatus.service.impl.ActeDecesService;
import spring.civilstatus.service.impl.ActeMariageService;
import spring.civilstatus.service.impl.ActeNaissanceService;

@Service
public class ActeServiceFactory {

	@Autowired
	private ActeNaissanceService acteNaissanceService;

	@Autowired
	private ActeMariageService acteMariageService;

	@Autowired
	private ActeDecesService acteDecesService;

	/*public ActeService getActeService(String type) {
		switch (type) {
		case "naissance":
			return acteNaissanceService;
		case "mariage":
			return acteMariageService;
		case "deces":
			return acteDecesService;
		default:
			throw new IllegalArgumentException("Type d'acte non pris en charge : " + type);
		}
	}*/
}
