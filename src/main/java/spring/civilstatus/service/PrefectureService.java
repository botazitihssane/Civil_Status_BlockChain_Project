package spring.civilstatus.service;

import java.util.List;

import spring.civilstatus.models.Prefecture;

public interface PrefectureService {
	Prefecture addPrefecture(Prefecture prefecture);

	Prefecture getPrefecture(int id);

	List<Prefecture> getPrefectures();

	void updatePrefecture(Prefecture prefecture);

	void deletePrefecture(int id);

	List<Prefecture> getPrefectureByRegion(int region);
}
