package com.midcoastmaineiacs.RecycleRush;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	public DoubleSolenoid arms = new DoubleSolenoid(0, 0, 1);
	public DoubleSolenoid lift = new DoubleSolenoid(0, 6, 7);

	public DigitalInput armLimitSwitch = new DigitalInput(1);
	public DigitalInput liftLimitSwitch = new DigitalInput(0);

	/**
	 * Set arm valve state
	 * @param value kForward opens arms, kReverse closes them
	 */
	public void setArms(DoubleSolenoid.Value value) {
		arms.set(value);
	}

	/**
	 * Set lift valve state
	 * @param value kForward goes up, kReverse goes down
	 */
	public void setLift(DoubleSolenoid.Value value) {
		lift.set(value);
	}

	@Override
	protected void initDefaultCommand() {}
}
