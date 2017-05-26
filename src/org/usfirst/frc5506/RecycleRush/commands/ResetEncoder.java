package org.usfirst.frc5506.RecycleRush.commands;

import org.usfirst.frc5506.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoder extends Command {
	
	public ResetEncoder() {
        requires(Robot.driveTrain);
    }

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.driveTrain.getWheelRotations().reset();
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.getWheelRotations().getDistance() == 0;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
