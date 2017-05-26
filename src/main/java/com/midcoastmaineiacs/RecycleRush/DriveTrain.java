package com.midcoastmaineiacs.RecycleRush;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	public final Talon left = new Talon(0);
	public final Talon right = new Talon(1);
	public final AnalogGyro gyro = new AnalogGyro(0);

	private double lastLeftSpeed = 0d;
	private double lastRightSpeed = 0d;
	private final boolean accelCurve = true;

	public DriveTrain() {
		gyro.setSensitivity(0.007); // idk I found this in RobotMap so it's here now
	}

	public void driveLeft(double speed) {
		lastLeftSpeed = speed;
		left.set(speed);
		if (Robot.rumble.getSelected())
			Robot.joystick.setRumble(RumbleType.kLeftRumble, Math.abs(speed));
		else
			Robot.joystick.setRumble(RumbleType.kLeftRumble, 0);
	}

	public void driveRight(double speed) {
		lastRightSpeed = speed;
		right.set(speed);
		if (Robot.rumble.getSelected())
			Robot.joystick.setRumble(RumbleType.kRightRumble, Math.abs(speed));
		else
			Robot.joystick.setRumble(RumbleType.kRightRumble, 0);
	}

	public void driveLeftCurved(double speed) {
		if (!accelCurve) {
			driveLeft(speed);
			return;
		}
		if (speed > 0) {
			if (speed > lastLeftSpeed + 0.04)
				driveLeft(lastLeftSpeed + 0.04);
			else
				driveLeft(speed);
		} else {
			// if (speed < lastLeftSpeed - 0.04)
			// left(lastLeftSpeed - 0.04);
			// else
			driveLeft(speed);
		}
	}

	public void driveRightCurved(double speed) {
		if (!accelCurve) {
			driveRight(speed);
			return;
		}
		if (speed > 0) {
			if (speed > lastRightSpeed + 0.04)
				driveRight(lastRightSpeed + 0.04);
			else
				driveRight(speed);
		} else {
			// if (speed < lastRightSpeed - 0.04)
			// right(lastRightSpeed - 0.04);
			// else
			driveRight(speed);
		}
	}

	public void driveArcade(double forward, double turn) {
		drive(forward + turn, forward - turn);
	}

	public void drive(double left, double right) {
		if (Math.abs(left) > 1) {
			left *= Math.abs(1 / left);
			right *= Math.abs(1 / left);
		}
		if (Math.abs(right) > 1) {
			left *= Math.abs(1 / right);
			right *= Math.abs(1 / right);
		}
		driveLeft(left);
		driveRight(right);
	}

	public double getGyro() {
		return gyro.getAngle();
	}

	/**
	 * @return Angle between 0 (inclusive) and 360 (exclusive)
	 */
	public double getGyroMod() {
		return getGyro() % 360;
	}

	/**
	 * Calculates how far (and which way) to turn to match a target angle
	 *
	 * @param target
	 *            target (will be normalized between 0 and 360)
	 * @return angle (between -180 and 180, inclusive)
	 */
	public double getTurningAngle(double target) {
		target = target % 360;
		double current = getGyroMod();
		if (Math.abs(target - current) <= 180) {
			return target - current;
		} else if (target < current) {
			return target + 360 - current;
		} else {
			return target - 360 - current;
		}
	}

	@Override
	protected void initDefaultCommand() {}
}
