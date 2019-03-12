package com.alliedtesting.automation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLJDOMqueryManager {

	public static void main(String[] args) {
		getManagers("004");
	}

	public static void getManagers(String empID) {
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("./src/main/resources/employee.xml");
			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();
			Map<String, Element> employeeMap = new HashMap<>();
			for (Element department : rootNode.getChildren()) {
				for (Element employee : department.getChildren()) {
						employeeMap.put(employee.getAttributeValue("empId"), employee);
				}
			}
			String managerID=empID;
			while (!managerID.equals("0")) {
				Element employee = employeeMap.get(managerID);
				System.out.print(employee.getAttributeValue("empId")+":"+ employee.getChildText("lastName") +" -> ");
				managerID = employee.getChildText("managerId");
			}
			System.out.println(employeeMap.get(managerID).getAttributeValue("empId")+":"+ employeeMap.get(managerID).getChildText("lastName"));
		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}
}
