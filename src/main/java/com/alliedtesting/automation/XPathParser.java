package com.alliedtesting.automation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XPathParser {

	public static void main(String[] args) {
		try {
			File inputFile = new File("./src/main/resources/employee.xml");
			// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/company/department/employee";
			NodeList nodeList = (NodeList) (xPath.compile(expression).evaluate(doc, XPathConstants.NODESET));
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println(node.getAttributes().item(0).getNodeName() + ": " +node.getAttributes().item(0).getTextContent());
				NodeList nodes = node.getChildNodes();
				for (int j = 0; j < nodes.getLength(); j++) {
					Node element = nodes.item(j);
					if (element.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(element.getNodeName() + ": "+ element.getTextContent());
					}
				}
				System.out.println("------------------------------------------------");
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

}
