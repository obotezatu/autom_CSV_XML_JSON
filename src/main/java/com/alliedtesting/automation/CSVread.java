package com.alliedtesting.automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVread {

	public static void commonCSVReadData(String filePath) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withHeader("First name", "Last name", "University", "Score")
								.withIgnoreHeaderCase().withTrim());) {
			for (CSVRecord csvRecord : csvParser) {
				String firstName = csvRecord.get("First name");
				String lastName = csvRecord.get("Last name");
				String university = csvRecord.get("University");
				String score = csvRecord.get("Score");
				System.out.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				System.out.println("First name : " + firstName);
				System.out.println("Last name : " + lastName);
				System.out.println("University : " + university);
				System.out.println("Score : " + score);
				System.out.println("---------------\n");
			}
		}
	}

	public static void openCSVReadData(String filePath) {
		try {
			FileReader fileReader = new FileReader(filePath);
			CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
			List<String[]> allData = csvReader.readAll();
			for (String[] row : allData) {
				for (String cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scannerCSVReadData(String filePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filePath));
		scanner.useDelimiter(",");
		int i = 0;
		while (scanner.hasNext()) {
			if (i % 4 != 0 || i!=0) {
				System.out.print(scanner.next() + " ");
			} else {
				System.out.println();
			}
			i++;
		}
		scanner.close();
	}
}
