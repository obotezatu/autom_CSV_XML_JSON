package com.alliedtesting.automation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLJDOMcreation {

	public static void main(String[] args) {
		jdomCreateDept();
	}
	
	public static void jdomCreateDept() {
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("./src/main/resources/employee.xml");
			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();
			Element department = new Element("department").setAttribute("name", "Administration").setAttribute("depId",
					"5");
			rootNode.addContent(department);
			Element employee = new Element("employee").setAttribute("empId", "006");
			department.addContent(employee);
			Element lastName = new Element("lastName").setText("Odobescu");
			Element firstName = new Element("firstName").setText("Elena");
			Element birthDate = new Element("birthDate").setText("30.01.1999");
			Element position = new Element("position").setText("Chief Executive Officer");
			Element skills = new Element("skills");
			Element managerId = new Element("managerId").setText("0");
			employee.addContent(lastName).addContent(firstName).addContent(birthDate).addContent(position)
					.addContent(skills).addContent(managerId);
			Element skill = new Element("skill").setText("very strong manager");
			skills.addContent(skill);
			skill = new Element("skill").setText("лавный исполнительный директор");
			skills.addContent(skill);
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("./src/main/resources/employee.xml"));
			System.out.println("File updated!");

		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}
}

