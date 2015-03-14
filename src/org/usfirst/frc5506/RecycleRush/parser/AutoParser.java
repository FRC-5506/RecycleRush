package org.usfirst.frc5506.RecycleRush.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoParser {
	
	public void parseFile(String fileName) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()) {
				parse(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void parse(String s) {
		if(s.toLowerCase().contains("drive")) {
			String[] driveParts = s.split(" ");
			System.out.println(driveParts[0] + " " + driveParts[1] + " " + driveParts[2]);
		}
	}
	
	public static void main(String[] args) {
		AutoParser parse = new AutoParser();
		parse.parse("./auto.txt");
	}
	
}
