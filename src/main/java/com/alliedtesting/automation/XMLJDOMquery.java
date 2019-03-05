package com.alliedtesting.automation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLJDOMquery {

	public static void main(String[] args) {
		jdomQuery("005");
	}

	public static void jdomQuery(String emp_id) {
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("./src/main/resources/employee.xml");
			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();
			List<Element> employees = new ArrayList<>();
			for (Element department : rootNode.getChildren()) {
				employees.addAll(department.getChildren());
			}
			Iterator<Element> iter = employees.iterator();
			while (iter.hasNext()) {
				Element employee = iter.next();
				if (emp_id.equals(employee.getAttributeValue("empId"))) {
					for (Element field : employee.getChildren()) {
						if ("skills".equals(field.getName())) {
							System.out.println("skills:");
							for (Element skill : field.getChildren()) {
								System.out.println("   " + skill.getText());
							}
						} else {
							System.out.println(field.getName() + " - " + field.getText());
						}
					}
				}
			}

		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}
}
