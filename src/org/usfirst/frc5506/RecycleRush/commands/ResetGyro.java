package org.usfirst.frc5506.RecycleRush.commands;

import org.usfirst.frc5506.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command {
	
	public ResetGyro() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.driveTrain.getGyro().reset();
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.getGyro().getAngle() == 0;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
