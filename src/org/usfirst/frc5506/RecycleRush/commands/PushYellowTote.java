package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PushYellowTote extends CommandGroup {
	
	public PushYellowTote() {
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(true, 180)); // With yellow tote: 180, w/o 120
		addSequential(new ResetEncoder());
	}
	
}
