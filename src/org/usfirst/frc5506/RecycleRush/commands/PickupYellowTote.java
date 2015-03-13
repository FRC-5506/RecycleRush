package org.usfirst.frc5506.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupYellowTote extends CommandGroup {
	
	public PickupYellowTote() {
		addSequential(new ArmCommand(false));
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ArmCommand(true));
		addSequential(new ElevatorCommand(false, false));
		addSequential(new DriveAuto(true, 210));
		addSequential(new ElevatorCommand(true, false));
		addSequential(new ArmCommand(false));
		addSequential(new ResetEncoder());
		addSequential(new DriveAuto(false, -24));
		addSequential(new ResetEncoder());
	}
	
}
