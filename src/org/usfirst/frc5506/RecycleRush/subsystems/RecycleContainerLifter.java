package org.usfirst.frc5506.RecycleRush.subsystems;

import org.usfirst.frc5506.RecycleRush.RobotMap;
import org.usfirst.frc5506.RecycleRush.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RecycleContainerLifter extends Subsystem {
	DoubleSolenoid rcSolenoid = RobotMap.rcSolenoid;

	@Override
	protected void initDefaultCommand() {
	}
	
	public void liftRecycleContainer() {
		rcSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void lowerRecycleContainer() {
		rcSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopLiftingMechanism() {
		rcSolenoid.set(DoubleSolenoid.Value.kOff);
	}

}
