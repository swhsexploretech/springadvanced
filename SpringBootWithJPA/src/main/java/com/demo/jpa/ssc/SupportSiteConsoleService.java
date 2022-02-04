package com.demo.jpa.ssc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportSiteConsoleService {	
	
	@Autowired
	private SSCRepository sscRepo;
	
	public List<SSCData> getAllData() {
		List<AdminConsoleMaster> dataList= sscRepo.findAll();
		List<SSCData> finalList = new ArrayList<SSCData>();
		dataList.forEach(a-> {
			SSCData data = new SSCData();
			data.setCategoryID(a.getCategory_id());
			data.setKeyDesc(a.getKeyDesc());
			data.setKeyValue(a.getKeyValue());
			finalList.add(data);
		});
		return finalList;
	}
	
	public AdminConsoleMaster getSpecificData(int id) {
		return sscRepo.getOne(id);
	}
	
	public void insertDataIntoSSC(AdminConsoleMaster data) {
		sscRepo.save(data);
	}
}
