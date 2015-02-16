package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupYellowTotes extends CommandGroup{

	public PickupYellowTotes() {
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ElevatorCommand(true, true));
		addSequential(new TurnCommand(true));
		addSequential(new DriveAuto(true, 5));
		//To do: set correct values for all DriveAuto
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 5));
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 5));
		addSequential(new TurnCommand(true));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new ElevatorCommand(false, true));
		addParallel(new ArmCommand(false));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ElevatorCommand(true, true));
		addSequential(new TurnCommand(true));
		addSequential(new DriveAuto(true, 8));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new ElevatorCommand(false, true));
		addSequential(new ArmCommand(false));
	}
	
}
