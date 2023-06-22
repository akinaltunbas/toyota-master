package com.project.toyotamaster.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.toyotamaster.services.ReportService;
import com.project.toyotamaster.dto.TravelCreateRequestDto;
import com.project.toyotamaster.dto.TravelUpdateRequestDto;
import com.project.toyotamaster.entities.Travel;
import com.project.toyotamaster.services.TravelServiceImpl;

@RestController
@RequestMapping("/admin/travel")
public class AdminTravelController {
	
	private TravelServiceImpl travelService;
	private ReportService reportService;
	
	
	public AdminTravelController(TravelServiceImpl travelService, ReportService reportService) {
		this.travelService = travelService;
		this.reportService = reportService;
	}

	@GetMapping("/listTravel")
	public  List<Travel> getAllTravels() {
		return travelService.getAllTravels();
	}

	@PostMapping("/createTravel")
	public Travel createOneTravel(@RequestBody TravelCreateRequestDto newTravelRequest) {
		return travelService.createOneTravel(newTravelRequest);
	}
	
	@GetMapping("/getTravel/{travelId}")
	public Travel getOneTravel(@PathVariable Long travelId) {
		return travelService.getTravelById(travelId);
	}
	
	@PutMapping("/updateTravel/{travelId}")
	public Travel updateOneTravel(@PathVariable Long travelId, @RequestBody TravelUpdateRequestDto updateTravel) {
		return travelService.updateOneTravelById(travelId, updateTravel);
	}
	
	@DeleteMapping("/deleteTravel/{travelId}") 
	public void deleteOneTravel(@PathVariable Long travelId) {
		travelService.deleteOneTravelById(travelId);
	}
	
	@GetMapping("/searcTravel")
		public List<Travel> searchTravel(@RequestParam Long userId){
			return travelService.getTravelSearch(userId);
		}
	
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=courses.xls";

		response.setHeader(headerKey, headerValue);
		
		reportService.generateExcel(response);
		
		response.flushBuffer();
	}
	@GetMapping("/searchUsername/{username}")
	public List<Travel> searchTravelUseranem(@PathVariable String username) {
		return  travelService.getTravelSearchUsername(username);
	}
	
}



