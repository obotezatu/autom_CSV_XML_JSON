package com.alliedtesting.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.opencsv.CSVWriter;

public class CSVcreate {

	public static void openCSVWriteData(String filePath) {
		File file = new File(filePath);
		List<String[]> data;
		try {
			FileWriter outputFile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputFile);
			data = inputRecords();
			writer.writeAll(data);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void commonCSVWriteData(String filePath) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
				CSVPrinter csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withHeader("First name", "Last name", "University", "Score"));) {
			List<String[]> data = inputRecords();
			csvPrinter.printRecords(data);
			csvPrinter.flush();
		} 
	}

	private static List<String[]> inputRecords() {
		String firstName;
		String lastName;
		String university;
		String score;
		List<String[]> data = new ArrayList<>();
		System.out.println("List of students");
		try (Scanner input = new Scanner(System.in)) {
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
				data.add(new String[] { firstName, lastName, university, score });
				System.out.print("Next? (y/n): ");
				next = input.nextLine();
				if (!"y".equals(next)) {
					System.out.println("End input");
					break;
				}
			}
		}
		return data;
	}
}
