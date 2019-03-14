package com.alliedtesting.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class StAXParserEmployee {
	public static void main(String[] args) {
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory
					.createXMLStreamReader(new FileInputStream("./src/main/resources/employee.xml"));
			String name;
			while (reader.hasNext()) {
				int type = reader.next();
				switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					switch (name) {
					case "company":
						System.out.println("------Our Company------");
						break;
					case "department":
						name = reader.getAttributeValue(null, "name");
						System.out.println("Department: " + name);
						System.out.print("-----------------------------------");
						break;
					case "employee":
						System.out.print("Employee ID: " + reader.getAttributeValue(null, "empId"));
						break;
					case "lastName":
						System.out.print("Last name: ");
						break;
					case "firstName":
						System.out.print("First name: ");
						break;
					case "birthDate":
						System.out.print("Bird date: ");
						break;
					case "position":
						System.out.print("Position: ");
						break;
					case "skills":
						System.out.print("Skills: ");
						break;
					case "skill":
						System.out.print("  - ");
						break;
					case "managerId":
						System.out.print("Manager Id: ");
						break;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					System.out.print(reader.getText());
					break;
				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
