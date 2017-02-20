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
	public static final int CAN_D_FL = 1; //14 On Robot
	public static final int CAN_D_RL = 2; //15 On Robot
	public static final int CAN_D_FR = 3; //1 On Robot
	public static final int CAN_D_RR = 4; //0 On Robot
		//Shooter
	public static final int CAN_SHT_L = 5; //9 On Robot
	public static final int CAN_SHT_R = 6; //10 On Robot
		//Ball
	public static final int CAN_BALL_LIFT = 7; //11 On Robot
	public static final int CAN_BALL_AGI = 8; //13 On Robot
	public static final int CAN_BALL_IT = 10; // On Robot
	public static final int CAN_BALL_AGI2 = 11; // On Robot
		//Winch
	public static final int CAN_WINCH = 9; //2 On Robot
		
	/*******SERVOs*******/
		//Camera Servos
	public static final int upDown = 0; //Not Used
	public static final int leftRight = 1; //Not Used
		//Ball Aim Servos
	public static final int BALL_Y_L = 2; //Left Ball Aimer Y Axis
	public static final int BALL_Y_R = 3; //Right Ball Aimer Y Axis
	public static final int BALL_X_L = 4; //Left Ball Aimer X Axis
	public static final int BALL_X_R = 5; //Right Ball Aimer X Axis
		//Gear Door Servos
	public static final int GEAR_DOOR_L = 6;
	public static final int GEAR_DOOR_R = 7;
	
		//Shifter Servos
	public static final int SHIFTER_L = 8;
	public static final int SHIFTER_R = 9;
	
	/***USB Controller***/
	public static final int USB_Driver = 0;
	public static final int USB_AUX = 1;
}
