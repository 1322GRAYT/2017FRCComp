package org.usfirst.frc.team1322.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/********CANs********/
		//Drives
	public static final int CAN_D_FL = 1;
	public static final int CAN_D_RL = 2;
	public static final int CAN_D_FR = 3;
	public static final int CAN_D_RR = 4;
		//Shooter
	public static final int CAN_SHT_L = 5;
	public static final int CAN_SHT_R = 6;
		//Ball
	public static final int CAN_BALL_LIFT = 7;
	public static final int CAN_BALL_AGI = 8;
	public static final int CAN_BALL_FEED = 9;
		//Winch
	public static final int CAN_WINCH = 10;
	
	/*******SERVOs*******/
		//Camera Servos
	public static final int upDown = 0;
	public static final int leftRight = 1;
		//Ball Aim Servos
	public static final int BALL_Y_L = 2;
	public static final int BALL_Y_R = 3;
	public static final int BALL_X_L = 4;
	public static final int BALL_X_R = 5;
		//Gear Door Servos
	public static final int GEAR_DOOR_L = 6;
	public static final int GEAR_DOOR_R = 7;
	
	/***USB Controller***/
	public static final int USB_Driver = 0;
	public static final int USB_AUX = 1;
}
