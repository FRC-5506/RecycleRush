package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupYellowTotes extends CommandGroup{

	public PickupYellowTotes() {
		addSequential(new ArmCommand(false));
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(false, -30));
		addSequential(new ResetEncoder());
		addSequential(new TurnCommand(false));
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(true, 60)); //Check value
		addSequential(new ResetEncoder());
		addSequential(new TurnCommand(true));
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(true, 30));
		addSequential(new ResetEncoder());
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ArmCommand(false));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(false, -210));
		addSequential(new ResetEncoder());
	}
	
}