package org.usfirst.frc.team1322.robot;

import org.usfirst.frc.team1322.robot.commands.BM_GearControl;
import org.usfirst.frc.team1322.robot.commands.BM_ShootBalls;
import org.usfirst.frc.team1322.robot.commands.BM_WinchControl;
import org.usfirst.frc.team1322.robot.triggers.ShooterTrigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {    
	
	public XboxController DriverStick = new XboxController(RobotMap.USB_Driver), 
						  AuxStick = new XboxController(RobotMap.USB_AUX);
	private ShooterTrigger shootTrigger = new ShooterTrigger();
	
	private Button 	OpenGear = new JoystickButton(AuxStick,6),
					CloseGear = new JoystickButton(AuxStick,5),
					WinchUp = new JoystickButton(AuxStick, 4),
					WinchDown = new JoystickButton(AuxStick, 1);
	
	
	public OI(){
		shootTrigger.whenActive(new BM_ShootBalls());
		OpenGear.whenPressed(new BM_GearControl(true));
		CloseGear.whenPressed(new BM_GearControl(false));
		WinchUp.whileHeld(new BM_WinchControl(true));
		WinchDown.whileHeld(new BM_WinchControl(false));
	}
}