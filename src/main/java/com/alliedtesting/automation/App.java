package com.alliedtesting.automation;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Create CSV with OpenCSV ");
		CreateCSV.openCSVWriteData("./src/main/resources/students.csv");

		System.out.println("Create CSV with common-CSV ");
		CreateCSV.commonCSVWriteData("./src/main/resources/studentsComm.csv");

		System.out.println("Read file with \"commonCSVReadData\"");
		System.out.println("-------------------------------------");
		ReadCSV.commonCSVReadData("./src/main/resources/studentsComm.csv");
		
		System.out.println("Read file with \"openCSVReadData\"");
		System.out.println("-------------------------------------");
		ReadCSV.openCSVReadData("./src/main/resources/students.csv");
	}
}
