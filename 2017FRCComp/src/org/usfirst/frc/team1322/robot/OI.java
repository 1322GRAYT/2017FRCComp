package org.usfirst.frc.team1322.robot;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {    
	
	public XBoxController DriverStick = new XBoxController(RobotMap.USB_Driver), 
						  AuxStick = new XBoxController(RobotMap.USB_AUX);		
	public OI(){
		
	}
}