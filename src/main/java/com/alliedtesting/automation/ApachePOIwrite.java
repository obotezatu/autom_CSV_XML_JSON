package com.alliedtesting.automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApachePOIwrite {

	public static void main(String[] args) {

		try {
			Workbook wb = new XSSFWorkbook();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("./src/main/resources/employee.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray departments = (JSONArray) jsonObject.get("department");
			Iterator<JSONObject> iteratorDep = departments.iterator();
			while (iteratorDep.hasNext()) {
				JSONObject department = iteratorDep.next();
				Sheet sheet = wb.createSheet(department.get("name").toString() + " ID - " + department.get("depId"));
				Row rowhead = sheet.createRow(0);
				CellStyle style = wb.createCellStyle();
				Font font = wb.createFont();
				font.setBold(true);
				style.setFont(font);
				rowhead.createCell(0).setCellValue("Emp ID");
				rowhead.createCell(1).setCellValue("Lastname");
				rowhead.createCell(2).setCellValue("Firstname");
				rowhead.createCell(3).setCellValue("Birthdate");
				rowhead.createCell(4).setCellValue("Manager ID");
				rowhead.createCell(5).setCellValue("Skills");
				for (int i = 0; i <= 5; i++) {
					rowhead.getCell(i).setCellStyle(style);
				}
				JSONArray employees = (JSONArray) department.get("employee");
				Iterator<JSONObject> iteratorEmp = employees.iterator();
				int rowNumber = 1;
				while (iteratorEmp.hasNext()) {
					JSONObject employee = iteratorEmp.next();
					CellStyle style2 = wb.createCellStyle();
					style2.setWrapText(true);
					Row row = sheet.createRow(rowNumber);
					row.createCell(0).setCellValue(employee.get("empId").toString());

					row.createCell(1).setCellValue(employee.get("lastName").toString());
					row.createCell(2).setCellValue(employee.get("firstName").toString());
					row.createCell(3).setCellValue(new SimpleDateFormat("dd.MM.yyyy").parse(employee.get("birthDate").toString()));
					row.createCell(4).setCellValue(employee.get("managerId").toString());
					row.createCell(5).setCellStyle(style2);
					JSONArray skills = (JSONArray) employee.get("skills");
					StringBuilder skillsCell = new StringBuilder();
					for (Object skill : skills) {
						skillsCell.append(String.format("- %s%n", skill));
					}
					row.getCell(5).setCellValue(skillsCell.toString());
					rowNumber++;
				}
			}
			OutputStream fileOut = new FileOutputStream("./src/main/resources/Employee.xlsx");
			wb.write(fileOut);
			System.out.println("Done.Excel was created");
			wb.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

}
