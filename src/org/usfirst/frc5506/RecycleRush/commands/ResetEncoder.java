package org.usfirst.frc5506.RecycleRush.commands;

import org.usfirst.frc5506.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoder extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.driveTrain.getWheelRotations().reset();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
