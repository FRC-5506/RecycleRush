package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveToAutoZone extends CommandGroup {
	
	public DriveToAutoZone() {
		addSequential(new DriveAuto(true, 12)); //TODO: fix value
		//addSequential(new ElevatorCommand(true, false));
		addSequential(new ResetEncoder());
	}

}
