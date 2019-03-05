package com.alliedtesting.automation;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDOMParser {

	public static void main(String[] args) {

		try {
			File inputFile = new File("./src/main/resources/employee.xml");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse(inputFile);
			document.getDocumentElement().normalize();
			NodeList depList = document.getElementsByTagName("department");
			for (int i = 0; i < depList.getLength(); i++) {
				Node depNode = depList.item(i);
				System.out.println("<<<" + depNode.getNodeName() + " "
						+ depNode.getAttributes().getNamedItem("name").getTextContent()
						+ ">>>\n----------------------------------\n");
				NodeList empList = depNode.getChildNodes();
				for (int j = 0; j < empList.getLength(); j++) {
					Node empNode = empList.item(j);
					if (empNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) empNode;
						System.out.print("ID:" + eElement.getAttribute("empId") + ", ");
						System.out.print(eElement.getElementsByTagName("lastName").item(0).getTextContent());
						System.out.print(" " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
						System.out.print(
								" (" + eElement.getElementsByTagName("birthDate").item(0).getTextContent() + ")");
						System.out.println(
								" - " + eElement.getElementsByTagName("position").item(0).getTextContent() + "\n");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
