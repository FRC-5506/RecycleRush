// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.RecycleRush.subsystems;

import org.usfirst.frc5506.RecycleRush.RobotMap;
import org.usfirst.frc5506.RecycleRush.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftMotor = RobotMap.driveTrainleftMotor;
    SpeedController rightMotor = RobotMap.driveTrainrightMotor;
    RobotDrive motors = RobotMap.driveTrainMotors;
    Encoder wheelRotations = RobotMap.driveTrainwheelRotations;
    Gyro gyro = RobotMap.driveTraingyro;
    AnalogInput rangeFinder = RobotMap.driveTrainrangeFinder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new ArcadeDriveWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public RobotDrive getMotors() {
    	return motors;
    }
    
    public void drive(double forwardSpeed, double turningSpeed) {
    	motors.arcadeDrive(forwardSpeed, turningSpeed);
    }
    
    // Autonomous drive functions
    public void driveForward() {
    	motors.arcadeDrive(0.5, 0);
    }
    
    public void driveBackwards() {
    	motors.arcadeDrive(-1, 0);
    }
    
    public void hardLeftTurn() {
    	motors.arcadeDrive(0, 1);
    }
    
    public void hardRightTurn() {
    	motors.arcadeDrive(0, -1);
    }
    
    public void softLeftTurn() {
    	motors.arcadeDrive(0, 0.5);
    }
    
    public void softRightTurn() {
    	motors.arcadeDrive(0, -0.5);
    }
    
    public void stopDriving() {
    	motors.stopMotor();
    }
    
    public Encoder getWheelRotations() {
    	return wheelRotations;
    }
    
    public Gyro getGyro() {
    	return gyro;
    }
    
    public double getRangefinderDistance() {
    	return rangeFinder.getVoltage();
    }
}

