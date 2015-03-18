package org.usfirst.frc5506.RecycleRush.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.usfirst.frc5506.RecycleRush.Robot;
import org.usfirst.frc5506.RecycleRush.commands.DriveAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

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
		// Ignore comment lines and look for a drive command
		if(!s.toLowerCase().startsWith("//") && s.toLowerCase().contains("drive")) {
			String[] driveParts = s.split(" ");
			Robot robot = new Robot();
			class ParsedClass extends CommandGroup {
				public ParsedClass() {
					addSequential(new DriveAuto(Boolean.getBoolean(driveParts[2]), Double.valueOf(driveParts[1])));
				}
			}
			robot.autonomousCommand = new ParsedClass();
		}
	}
	
}
