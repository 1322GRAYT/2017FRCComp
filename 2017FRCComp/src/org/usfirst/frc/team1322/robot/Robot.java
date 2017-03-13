
package org.usfirst.frc.team1322.robot;

import org.usfirst.frc.team1322.robot.commands.AM_BlueShoot;
import org.usfirst.frc.team1322.robot.commands.AM_DriveForwardGear;
import org.usfirst.frc.team1322.robot.commands.AM_DriveToWhite;
import org.usfirst.frc.team1322.robot.commands.AM_GyroDistanceForward;
import org.usfirst.frc.team1322.robot.commands.AM_RedShoot;
import org.usfirst.frc.team1322.robot.commands.AM_ShooterAuton;
import org.usfirst.frc.team1322.robot.subsystems.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public static final DriveSubsystem DriveSystem = new DriveSubsystem();
	//public static final CameraSubsystem CameraSystem = new CameraSubsystem();
	public static final WinchSubsystem WinchSubsystem = new WinchSubsystem();
	public static final ShooterSubsystem ShooterSubsystem = new ShooterSubsystem();
	public static final GearSubsystem GearSubsystem = new GearSubsystem();
	public static Gyro gyro;
	
	
	public static OI oi;
	
	public static NetworkTable camTable;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	
	@Override
	public void robotInit() {
		oi = new OI();
		gyro = new ADXRS450_Gyro();
		//camTable = NetworkTable.getTable(RobotMap.ContourReport);
		
		//chooser.addDefault("Drive & Drop Gear", new AM_DriveForwardGear());
		//chooser.addObject("Just Shoot", new AM_ShooterAuton());
		//chooser.addObject("Drive to White", new AM_DriveToWhite());
		//chooser.addObject("Shoot,BKWRD,FRWRD (maybe Red)", new AM_RedShoot());
		//chooser.addObject("Shoot,BKWRD,FRWRD (maybe Blue)", new AM_BlueShoot());
		chooser.addObject("GyroForward", new AM_GyroDistanceForward());
		SmartDashboard.putData("Auto mode", chooser);
		
		
		CameraServer cam1 = CameraServer.getInstance();
		cam1.startAutomaticCapture(0).setResolution(640, 480);
		
		//UsbCamera gearCam = new UsbCamera("cam0", 0);
		//gearCam.setResolution(640, 480);
		//MjpegServer gearServer = new MjpegServer("Gear Cam 0", 1183);
		//gearServer.setSource(gearCam); 	
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		
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
