package org.usfirst.frc.team1322.robot;

import org.usfirst.frc.team1322.robot.commands.AC_DriveAuton;
import org.usfirst.frc.team1322.robot.commands.AC_DriveToPosition;
import org.usfirst.frc.team1322.robot.commands.AC_GyroTurn;
import org.usfirst.frc.team1322.robot.commands.AC_TurnGyro;
import org.usfirst.frc.team1322.robot.commands.BM_BackfeedShooter;
import org.usfirst.frc.team1322.robot.commands.BM_BallPickup;
import org.usfirst.frc.team1322.robot.commands.BM_GearControl;
import org.usfirst.frc.team1322.robot.commands.BM_GearShift;
import org.usfirst.frc.team1322.robot.commands.BM_ShootBalls;
import org.usfirst.frc.team1322.robot.commands.BM_TestShooter;
import org.usfirst.frc.team1322.robot.commands.BM_WinchControl;
import org.usfirst.frc.team1322.robot.triggers.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {    
	
	public final static XboxController DriverStick = new XboxController(RobotMap.USB_Driver),
						  AuxStick = new XboxController(RobotMap.USB_AUX);
	private ShooterTrigger 	shootTrigger;
	private Backfeed		Backfeed;
	private BallIn			BallIn;
	private BallOut			BallOut;
	
	private Button 	OpenGear,
					CloseGear,
					WinchUp,
					WinchDown,
					TestBed,
					TestBed2,
					ShiftHigh,
					ShiftLow;
	
	
	public OI(){
		//shootTrigger = new ShooterTrigger();
		//Backfeed = new Backfeed();
		
		OpenGear = new JoystickButton(AuxStick,6);
		CloseGear = new JoystickButton(AuxStick,5);
		WinchUp = new JoystickButton(AuxStick, 4);
		WinchDown = new JoystickButton(AuxStick, 1);
		ShiftHigh = new JoystickButton(DriverStick, 6);
		ShiftLow = new JoystickButton(DriverStick, 5);
		
		//BallIn = new BallIn();
		//BallOut = new BallOut();
		
		
		//TestBed = new JoystickButton(DriverStick, 1);
		//TestBed2 = new JoystickButton(DriverStick, 2);
		
		//TestBed.toggleWhenPressed(new AC_DriveToPosition(72, true, -.5, 0));
		//TestBed2.whenPressed(new AC_TurnGyro(45, true));
		
		
		//BallIn.whileActive(new BM_BallPickup(true));
		//BallOut.whileActive(new BM_BallPickup(false));
		//shootTrigger.whileActive(new BM_ShootBalls());
		//Backfeed.whileActive(new BM_BackfeedShooter());
		//shootTrigger.whileActive(new BM_TestShooter());
		ShiftHigh.whenPressed(new BM_GearShift(true));
		ShiftLow.whenPressed(new BM_GearShift(false));
		OpenGear.whenPressed(new BM_GearControl(true));
		OpenGear.whenReleased(new BM_GearControl(false));
		CloseGear.whenPressed(new BM_GearControl(true));
		WinchUp.whileHeld(new BM_WinchControl(true));
		WinchDown.whileHeld(new BM_WinchControl(false));
	}
}