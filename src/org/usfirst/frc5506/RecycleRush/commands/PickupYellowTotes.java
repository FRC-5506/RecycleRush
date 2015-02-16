package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupYellowTotes extends CommandGroup{

	public PickupYellowTotes() {
		addSequential(new ElevatorCommand(true, false));
		addSequential(new DriveAuto(true, 42));
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 81));
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 42));
		addSequential(new ElevatorCommand(false, false));
		addParallel(new ArmCommand(false));
		addSequential(new ArmCommand(true));
		//assuming that false means the arms open
		addSequential(new ElevatorCommand(true, false));
		addSequential(new DriveAuto(false, 42));
		addSequential(new TurnCommand(true));
		addSequential(new DriveAuto(true, 81));
		addSequential(new TurnCommand(false));
		addSequential(new DriveAuto(true, 42));
		addSequential(new ElevatorCommand(false, false));
		addParallel(new ArmCommand(false));
		addSequential(new ArmCommand(true));
		addSequential(new DriveAuto(false, 42));
		addSequential(new TurnCommand(true));
		addSequential(new TurnCommand(true));
		addSequential(new DriveAuto(true, 107));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new ArmCommand(false));
		addSequential(new DriveAuto(false, 36));
		
	}
	
}