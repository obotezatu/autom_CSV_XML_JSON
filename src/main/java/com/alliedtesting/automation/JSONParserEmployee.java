package com.alliedtesting.automation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParserEmployee {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
            Object obj = parser.parse(new FileReader("./src/main/resources/employee.json"));
           JSONObject jsonObject = (JSONObject) obj;           
            JSONArray departments = (JSONArray) jsonObject.get("department");
            Iterator<JSONObject> iteratorDep = departments.iterator();
            while (iteratorDep.hasNext()) {
            	JSONObject department = iteratorDep.next();
            	System.out.println("-------------------------------");
                System.out.println(">>> " + department.get("name")+ " <<<");
                System.out.println("-------------------------------");
                JSONArray employees = (JSONArray) department.get("employee");
                Iterator<JSONObject> iteratorEmp = employees.iterator();
                while(iteratorEmp.hasNext()) {
                	JSONObject employee = iteratorEmp.next();
                	System.out.println("empId: " + employee.get("empId"));
                	System.out.println("Last name: " + employee.get("lastName"));
                	System.out.println("First name: " + employee.get("firstName"));
                	System.out.println("Position: " + employee.get("position"));
                	System.out.println("Skills: ");
                	JSONArray skills = (JSONArray)employee.get("skills");
                	for(Object skill: skills) {
                		System.out.println("  - " + skill);
                		}
                	System.out.println("managerId: " + employee.get("managerId")+ "\n");                	
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
