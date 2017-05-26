package com.midcoastmaineiacs.RecycleRush;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public Command auto;

	/** Some drivers may prefer rumble to be off, hence the toggle */
	public static SendableChooser<Boolean> rumble;

	public static DriveTrain driveTrain;
	public static Arm arm;

	public static Joystick joystick = new Joystick(0);

	public void robotInit() {
		driveTrain = new DriveTrain();
		arm = new Arm();

		LiveWindow.addActuator("DriveTrain", "Left", driveTrain.left);
		LiveWindow.addActuator("DriveTrain", "Right", driveTrain.right);
		LiveWindow.addSensor("DriveTrain", "Gyro", driveTrain.gyro);
		LiveWindow.addActuator("Arm","Arms", arm.arms);
		LiveWindow.addActuator("Arm", "Lift", arm.lift);
		driveTrain.gyro.calibrate();

		rumble = new SendableChooser<>();
		rumble.addDefault("Rumble On", true);
		rumble.addObject("Rumble Off", false);
		SmartDashboard.putData("Rumble", rumble);

		System.out.println("All systems go!");
	}

	public void testPeriodic() {
		LiveWindow.run();
	}

	public void autonomousInit() {}

	public void robotPeriodic() {
		// push gyro data in case camera mount falls (also useful for debugging)
		// normally gyro data is inverted as robot starts backwards when powered on, so the "+ 180" flips it
		SmartDashboard.putNumber("Heading", (driveTrain.getGyro() + 180) % 360);
		// report power setting
		SmartDashboard.putBoolean("Power", fullPower);
		SmartDashboard.putBoolean("Arcade", arcade);
	}

	////////////
	// Teleop //
	////////////

	private boolean lbWasPressed = false;
	private boolean rbWasPressed = false;
	private boolean arcade = true;
	/** "true" = 100% power (competition mode), "false" = 50% power (demonstration/small space mode) */
	private boolean fullPower = true;
	/** "true" adds a 15% dead zone in the middle of the controller to ensure joysticks rest in non-motor-moving position */
	private boolean deadZone = true;

	/*
	 * Current mappings:
	 *
	 * Left stick  Arcade drive (when in arcade mode)
	 * Sticks      Tank drive (when in tank mode)
	 * LB          Toggle power
	 * RB          Toggle arcade/tank mode (indicated on SmartDashboard, defaults to arcade)
	 *
	 * POV            Drive arcade (temporarily disables other drive base controls)
	 * Right stick X  Additional turning control while using POV arcade drive
	 * Right trigger  Throttle for POV arcade drive
	 *
	 * A  Close arms
	 * B  Open arms
	 * X  Lower lift
	 * Y  Raise lift
	 */
	public void teleopPeriodic() {
		//edu.wpi.first.wpilibj.command.Scheduler.getInstance().run(); // just in case a Command is running...

		// speed toggle
		if (!lbWasPressed && joystick.getRawButton(5)) { // LB
			lbWasPressed = true;
			fullPower = !fullPower;
		} else if (lbWasPressed && !joystick.getRawButton(5))
			lbWasPressed = false;

		if (!rbWasPressed && joystick.getRawButton(6)) {
			rbWasPressed = true;
			arcade = !arcade;
		} else if (rbWasPressed && !joystick.getRawButton(6))
			rbWasPressed = false;

		if (joystick.getRawButton(1))
			arm.setArms(DoubleSolenoid.Value.kReverse);
		else if (joystick.getRawButton(2))
			arm.setArms(DoubleSolenoid.Value.kForward);
		else
			arm.setArms(DoubleSolenoid.Value.kOff);
		if (joystick.getRawButton(3))
			arm.setLift(DoubleSolenoid.Value.kReverse);
		else if (joystick.getRawButton(4))
			arm.setLift(DoubleSolenoid.Value.kForward);
		else
			arm.setArms(DoubleSolenoid.Value.kOff);

		if (joystick.getPOV() != -1) {
			double forward = Math.cos(Math.toRadians(joystick.getPOV()));
			double turn = Math.sin(Math.toRadians(joystick.getPOV())) + joystick.getRawAxis(4); // 4 = right X
			driveTrain.driveArcade(forward * -joystick.getZ(), turn * -joystick.getZ());
		} else {
			if (arcade) {
				driveTrain.driveArcade(joystick.getY(), joystick.getX());
			} else {
				// left axis = 1, right axis = 5
				double leftSpeed = -joystick.getRawAxis(1);
				double rightSpeed = -joystick.getRawAxis(5);
				driveTrain.driveLeftCurved(!deadZone || Math.abs(leftSpeed) > 0.15 ? leftSpeed * (fullPower ? 1 : 0.5) : 0);
				driveTrain
					.driveRightCurved(!deadZone || Math.abs(rightSpeed) > 0.15 ? rightSpeed * (fullPower ? 1 : 0.5) : 0);
			}
		}


	}
}
