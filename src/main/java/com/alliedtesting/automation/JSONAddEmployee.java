package com.alliedtesting.automation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONAddEmployee {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		String[] employeeFeatures = { "empId", "lastName", "firstName", "position", "skills", "managerId" };
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("New department name:");
			String newDepartmentName = scanner.nextLine();
			System.out.println("Department ID:");
			String departmentID = scanner.nextLine();
			JSONArray newEmployee = new JSONArray();
			//JSONObject element = new JSONObject();
			JSONArray skills1 = new JSONArray();
			for (String feature : employeeFeatures) {
				JSONObject element = new JSONObject();
				String feat = "";
				System.out.print(feature + ": ");
				if ("skills".equals(feature)) {
					while (!"n".equals(feat)) {
						System.out.print("Skill (\"n\" for end skills) : ");
						feat = scanner.nextLine();
						skills1.add(feat);
					}
					element.put(feature, skills1);
				} else {
					feat = scanner.nextLine();
					element.put(feature, feat);
				}
				newEmployee.add(element);
			}
			scanner.close();

			Object obj = parser.parse(new FileReader("./src/main/resources/employee.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray departments = (JSONArray) jsonObject.get("department");
			JSONObject newDepartment = new JSONObject();

			newDepartment.put("name", newDepartmentName);
			newDepartment.put("depId", departmentID);
			newDepartment.put("employee", newEmployee);
			departments.add(newDepartment);

			Iterator<JSONObject> iteratorDep = departments.iterator();
			while (iteratorDep.hasNext()) {
				JSONObject department = iteratorDep.next();
				System.out.println("-------------------------------");
				System.out.println(">>> " + department.get("name") + " <<<");
				System.out.println("-------------------------------");
				JSONArray employees = (JSONArray) department.get("employee");
				Iterator<JSONObject> iteratorEmp = employees.iterator();
				while (iteratorEmp.hasNext()) {
					JSONObject employee = iteratorEmp.next();
					System.out.println("empId: " + employee.get("empId"));
					System.out.println("Last name: " + employee.get("lastName"));
					System.out.println("First name: " + employee.get("firstName"));
					System.out.println("Position: " + employee.get("position"));
					System.out.println("Skills: ");
					JSONArray skills = (JSONArray) employee.get("skills");
					for (Object skill : skills) {
						System.out.println("  - " + skill);
					}
					System.out.println("managerId: " + employee.get("managerId") + "\n");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
