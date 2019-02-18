package com.alliedtesting.automation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class CreateCSV {

	public static void openCSVWriteData(String filePath) {
		File file = new File(filePath);
		List<String[]> data;
		try{
			FileWriter outputFile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputFile);
			data = inputRecords();
			writer.writeAll(data);
			writer.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	private static List<String[]>  inputRecords() {
		String firstName;
		String lastName;
		String university;
		String score;
		//String[] student = new String[4];
		List<String[]> data = new ArrayList<>();
		System.out.println("List of students");
		try(Scanner input = new Scanner(System.in)){
			boolean flag = true;
			String next; 
			while (flag) {
				System.out.print("First Name: ");
				firstName = input.nextLine();
				System.out.print("Lirst Name: ");
				lastName = input.nextLine();
				System.out.print("University: ");
				university = input.nextLine();
				System.out.print("Score: ");
				score = input.nextLine();
				data.add(new String[] {firstName, lastName, university, score});
				System.out.print("Next? (y/n): ");
				next = input.nextLine();
				if (!"y".equals(next)) {
					break;
				}
			}
		}
		return data;
	}
}
