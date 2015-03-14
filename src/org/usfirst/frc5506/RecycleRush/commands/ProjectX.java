package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ProjectX extends CommandGroup {
	
	public ProjectX() {
		addSequential(new TurnCommand(true, 1)); //Turn for 1 second, right
		addSequential(new TurnCommand(false, 0.5));
		addSequential(new DriveAuto(true, 30)); //TODO: Change value to correct value
		//TODO: Run in parallel
		addSequential(new ArmCommand(false));
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new DriveAuto(true, 50)); //TODO: change to correct value
		addSequential(new ElevatorCommand(true, 1));
		addSequential(new ArmCommand(false));
		addSequential(new ElevatorCommand(true, 1));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new TurnCommand(false, 0.5));
		addSequential(new TurnCommand(true, 1)); //Turn for 1 second, right
		addSequential(new TurnCommand(false, 0.5));
		addSequential(new DriveAuto(true, 30)); //TODO: Change value to correct valueaddSequential(new ElevatorCommand(true, 1));
		addSequential(new ArmCommand(false));
		addSequential(new ElevatorCommand(true, 1));
		addSequential(new ArmCommand(true));
		addSequential(new TurnCommand(true, 1));
		addSequential(new DriveAuto(true, 120));
	}
	
}
