package com.alliedtesting.automation;

import java.io.IOException;

public class MainCSV {
	public static void main(String[] args) throws IOException {
		/*System.out.println("Create CSV with OpenCSV ");
		CSVcreate.openCSVWriteData("./src/main/resources/students.csv");

		System.out.println("Create CSV with common-CSV ");
		CSVcreate.commonCSVWriteData("./src/main/resources/studentsComm.csv");
*/
		System.out.println("Read file with \"commonCSVReadData\"");
		System.out.println("-------------------------------------");
		CSVreader.commonCSVReadData("./src/main/resources/studentsComm.csv");
		System.out.println("-------------------------------------\n\n");
		
		System.out.println("Read file with \"openCSVReadData\"");
		System.out.println("-------------------------------------");
		CSVreader.openCSVReadData("./src/main/resources/students.csv");
		System.out.println("-------------------------------------\n\n");
		
		System.out.println("Read file with \"scannerCSVReadData\"");
		System.out.println("-------------------------------------");
		CSVreader.scannerCSVReadData("./src/main/resources/students.csv");
		System.out.println("-------------------------------------\n\n");
	}
}
