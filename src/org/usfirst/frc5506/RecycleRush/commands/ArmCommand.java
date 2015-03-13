// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.RecycleRush.commands;

import org.usfirst.frc5506.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Noah Howard
 * 
 * TODO: This whole thing.
 */
public class  ArmCommand extends Command {
	
	private boolean moveIn;
	
	public ArmCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.arms);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
	
	public ArmCommand(boolean moveIn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.arms);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
       this.moveIn = moveIn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!moveIn) {
    		Robot.arms.moveOut();
    		setTimeout(1);
    	} else {
    		Robot.arms.moveIn();
    		setTimeout(1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
