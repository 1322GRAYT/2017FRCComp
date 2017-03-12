
package org.usfirst.frc.team1322.robot;

import java.text.DecimalFormat;

import org.usfirst.frc.team1322.robot.commands.AM_BlueShoot;
import org.usfirst.frc.team1322.robot.commands.AM_DriveForwardGear;
import org.usfirst.frc.team1322.robot.commands.AM_DriveToWhite;
import org.usfirst.frc.team1322.robot.commands.AM_RedShoot;
import org.usfirst.frc.team1322.robot.commands.AM_ShooterAuton;
import org.usfirst.frc.team1322.robot.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static BNO055 imu; 
	public static final DriveSubsystem DriveSystem = new DriveSubsystem();
	//public static final CameraSubsystem CameraSystem = new CameraSubsystem();
	public static final WinchSubsystem WinchSubsystem = new WinchSubsystem();
	public static final ShooterSubsystem ShooterSubsystem = new ShooterSubsystem();
	public static final GearSubsystem GearSubsystem = new GearSubsystem();
	//public static final GyroSubsystem GyroSubsystem = new GyroSubsystem();
	
	private double[] pos = new double[3]; // [x,y,z] position data
	private BNO055.CalData cal;
	private DecimalFormat f = new DecimalFormat("+000.000;-000.000");
	
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	
	@Override
	public void robotInit() {
		oi = new OI();
		
		chooser.addDefault("Drive & Drop Gear", new AM_DriveForwardGear());
		chooser.addObject("Just Shoot", new AM_ShooterAuton());
		chooser.addObject("Drive to White", new AM_DriveToWhite());
		chooser.addObject("Shoot,BKWRD,FRWRD (maybe Red)", new AM_RedShoot());
		chooser.addObject("Shoot,BKWRD,FRWRD (maybe Blue)", new AM_BlueShoot());
		SmartDashboard.putData("Auto mode", chooser);
		imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS,
				BNO055.vector_type_t.VECTOR_EULER);
		
		
		CameraServer cam1 = CameraServer.getInstance();
		cam1.startAutomaticCapture(0).setResolution(640, 480); 
		
		//UsbCamera gearCam = new UsbCamera("cam0", 0);
		//gearCam.setResolution(640, 480);
		//MjpegServer gearServer = new MjpegServer("Gear Cam 0", 1183);
		//gearServer.setSource(gearCam); 	
	}

	@Override
	public void disabledInit() {
		SmartDashboard.putBoolean("Present", imu.isSensorPresent());
		SmartDashboard.putBoolean("Initialized", imu.isInitialized());
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		System.out.println("COMMS: " + imu.isSensorPresent()
						+ ", INITIALIZED: " + imu.isInitialized()
		+ ", CALIBRATED: " + imu.isCalibrated());
		if(imu.isInitialized()){
			pos = imu.getVector();

			/* Display the floating point data */
			System.out.println("\tX: " + f.format(pos[0])
				+ " Y: " + f.format(pos[1]) + " Z: " + f.format(pos[2])
				+ "  H: " + imu.getHeading());

			/* Display calibration status for each sensor. */
			cal = imu.getCalibration();
			System.out.println("\tCALIBRATION: Sys=" + cal.sys
					+ " Gyro=" + cal.gyro + " Accel=" + cal.accel
					+ " Mag=" + cal.mag);SmartDashboard.putNumber("Heading", imu.getHeading());
					SmartDashboard.putBoolean("Present", imu.isSensorPresent());
					SmartDashboard.putBoolean("Initialized", imu.isInitialized());
		}
		
	}
	
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Heading", imu.getHeading());
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
