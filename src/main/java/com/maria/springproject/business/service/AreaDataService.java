package com.maria.springproject.business.service;


import java.util.List;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maria.springproject.dto.PreMunDto;
import com.maria.springproject.entity.MunicipalityEntity;
import com.maria.springproject.entity.PrefectureEntity;
import com.maria.springproject.pojo.Lists;
import com.maria.springproject.pojo.Municipality;
import com.maria.springproject.pojo.Prefecture;
import com.maria.springproject.repository.MunicipalitiesRepository;
import com.maria.springproject.repository.PrefecturesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class AreaDataService {
	
	private static final Logger logger = LogManager.getLogger(AreaDataService.class);
	
	@Autowired
	private PrefecturesRepository prefecturesRepository;
	
	
	@Autowired
	private MunicipalitiesRepository municipalitiesRepository;
	
	
	public void fetchAreas() {
		Lists areasLists = getAreasFromExternalService();
		saveAreas(areasLists);
		getDeptEmployeesInnerJoin();
	}
	
	
	public Lists getAreasFromExternalService() {
		try {
			String url = "https://devsrv.liknoss.com/crs-core-1.0-SNAPSHOT/services/openseas/agencies/area-data/en/88";
			RestTemplate restTemplate = new RestTemplate();
			Lists areas = restTemplate.getForObject(url, Lists.class);
			return areas;
		}catch(Exception e){
			logger.error("The external service cannot be reached --- getAreasFromExternalService",e);
			return null;
		}
	}
	
	
	
	public void saveAreas(Lists lists) {
		for (Prefecture prefecture : lists.getPrefectures()) {
			PrefectureEntity prefectureEntity = new PrefectureEntity();
			prefectureEntity.setName(prefecture.getName());
			prefectureEntity.setId(prefecture.getId());
			prefectureEntity.setParentId(prefecture.getParentId());
			prefectureEntity.setCountryId(prefecture.getCountryId());
			prefecturesRepository.save(prefectureEntity);
		}
		for (Municipality municipality : lists.getMunicipalities()) {
			MunicipalityEntity municipalityEntity = new MunicipalityEntity();
			municipalityEntity.setName(municipality.getName());
			municipalityEntity.setId(municipality.getId());
			municipalityEntity.setParentId(municipality.getParentId());
			municipalityEntity.setCountryId(municipality.getCountryId());
			municipalitiesRepository.save(municipalityEntity);
		}
	}

	
	//Print values from database to the console	
	public void getDeptEmployeesInnerJoin() {
		List<PreMunDto> list = municipalitiesRepository.fetchEmpDeptDataInnerJoin();
		MultiMap<String, List<String>> multiMapDemo = new MultiValueMap();
		for (PreMunDto premundto : list) {
			multiMapDemo.put(premundto.getPreName(), premundto.getMunName());
		}
		for(String key : multiMapDemo.keySet()) {
			  System.out.println(key+": "+multiMapDemo.get(key));
		}
	}
}
