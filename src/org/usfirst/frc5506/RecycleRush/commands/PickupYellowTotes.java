package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupYellowTotes extends CommandGroup{

	public PickupYellowTotes(){
		addSequential(new ElevatorCommand(true));
		addSequential(new TurnCommand(true));
		addSequential(new DriveAuto(true, 5));
		//To do: set correct values for all DriveAuto
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 5));
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 5));
		addSequential(new TurnCommand(true));
		addSequential(new ElevatorCommand(false));
		addParallel(new ArmCommand(false));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(true));
		addSequential(new TurnCommand(true));
		addSequential(new DriveAuto(true, 8));
		addSequential(new ElevatorCommand(false));
		addSequential(new ArmCommand(false));
	}
	
}
