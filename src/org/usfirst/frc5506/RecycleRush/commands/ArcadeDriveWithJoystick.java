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
import org.usfirst.frc5506.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Noah Howard
 */
public class  ArcadeDriveWithJoystick extends Command {

    public ArcadeDriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forwardSpeed = Robot.oi.getDriverJoystick().getY() * -1;
    	double turningSpeed = Robot.oi.getDriverJoystick().getX() * -1;
    	if(Math.abs(Robot.oi.getDriverJoystick().getX()) > Math.abs(Robot.oi.getDriverJoystick().getY())) {
        	Robot.oi.getDriverJoystick().setRumble(RumbleType.kLeftRumble, (float) Math.abs(Robot.oi.getDriverJoystick().getX()));
        	Robot.oi.getDriverJoystick().setRumble(RumbleType.kRightRumble, (float) Math.abs(Robot.oi.getDriverJoystick().getX()));
    	} else {
        	Robot.oi.getDriverJoystick().setRumble(RumbleType.kLeftRumble, (float) Math.abs(Robot.oi.getDriverJoystick().getY()));
        	Robot.oi.getDriverJoystick().setRumble(RumbleType.kRightRumble, (float) Math.abs(Robot.oi.getDriverJoystick().getY()));
    	}
    	
    	Robot.driveTrain.drive(forwardSpeed, turningSpeed);
        SmartDashboard.putNumber("Encoder", Robot.driveTrain.getWheelRotations().getDistance() * 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
