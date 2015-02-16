package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveToAutoZone extends CommandGroup {
	
	public DriveToAutoZone() {
		addSequential(new DriveForwardRangeFinder()); //TODO: fix value
		addSequential(new ResetEncoder());
	}

}
