package com.demo.jpa.ssc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ssc")
public class SupportSiteController {
	
	
	@Autowired
	private SupportSiteConsoleService service;
	
	
	@GetMapping("/getAll")
	public List<SSCData> getAllValues(){
		return service.getAllData();
	}
	
	@PostMapping("/addData")
	public void addData(@RequestBody AdminConsoleMaster data) {
		service.insertDataIntoSSC(data);
	}

}
