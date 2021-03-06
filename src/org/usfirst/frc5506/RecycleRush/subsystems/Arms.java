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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * @author Tori Staples
 */
public class Arms extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid armSolenoid = RobotMap.armSolenoid;
    DigitalInput armWidthLimit = RobotMap.armWidthLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveIn() {
    	armSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void moveOut() {
    	armSolenoid.set(DoubleSolenoid.Value.kForward);
    }

	public void stop() {
		armSolenoid.set(DoubleSolenoid.Value.kOff);
	}
    
    public DigitalInput getLimitSwitch() {
    	return armWidthLimit;
    }
}

