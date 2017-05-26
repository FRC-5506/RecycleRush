package org.usfirst.frc5506.RecycleRush.commands;

import org.usfirst.frc5506.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RecycleContainerCommand extends Command {
	private boolean isLifting;
	private boolean isDone;
	
	public RecycleContainerCommand(boolean isLifting, boolean isDone) {
		requires(Robot.rcLift);
		this.isLifting = isLifting;
		this.isDone = isDone;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if(!isDone) {
			if(isLifting) {
				Robot.rcLift.liftRecycleContainer();
			} else {
				Robot.rcLift.lowerRecycleContainer();
			}
		} else {
			Robot.rcLift.stopLiftingMechanism();
		}
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
