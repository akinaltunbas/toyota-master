package com.project.toyotamaster.services;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.toyotamaster.entities.Travel;
import com.project.toyotamaster.repositories.TravelRepository;
@Service
public class ReportService {
	
	@Autowired
	private TravelRepository travelRepository; 

	
	public void generateExcel(HttpServletResponse response) throws Exception {
		
		List<Travel> travels = travelRepository.findAll();
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Courses Info");
		HSSFRow row = sheet.createRow(0);
		

		row.createCell(0).setCellValue("Bölümü");
		row.createCell(1).setCellValue("Müdürü");
		row.createCell(1).setCellValue("Seyahat Eden");
		row.createCell(2).setCellValue("Seyahat Başlangıç");
		row.createCell(2).setCellValue("Seyahat Sonu");
		row.createCell(2).setCellValue("Seyahat Yeri");
		row.createCell(2).setCellValue("Gidiş Amacı");
		row.createCell(2).setCellValue("Proje Kodu");
		
		int dataRowIndex = 1;
		
		for (Travel travel : travels) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(travel.getUser().getDepartment());
			dataRow.createCell(0).setCellValue(travel.getUser().getDepartmentManager());
			dataRow.createCell(1).setCellValue(travel.getUsername());
			dataRow.createCell(3).setCellValue(travel.getTravelStart());
			dataRow.createCell(4).setCellValue(travel.getTravelEnd());
			dataRow.createCell(5).setCellValue(travel.getTravelDestination());
			dataRow.createCell(6).setCellValue(travel.getPurposeOfGoing());
			dataRow.createCell(7).setCellValue(travel.getProjectCode());
			dataRowIndex++;
		}

		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();


		
	}

}
