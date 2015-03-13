package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveToAutoZone extends CommandGroup {
	
	public DriveToAutoZone() {
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(true, 120));
		addSequential(new ResetEncoder());
	}

}
