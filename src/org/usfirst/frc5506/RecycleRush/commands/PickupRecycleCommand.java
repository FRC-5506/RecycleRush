package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupRecycleCommand extends CommandGroup {
	
	public PickupRecycleCommand() {
		addSequential(new ElevatorCommand(true, false));
		addSequential(new RecycleContainerCommand(true, false));
		addSequential(new DriveAuto(true, 180));
	}
	
}
