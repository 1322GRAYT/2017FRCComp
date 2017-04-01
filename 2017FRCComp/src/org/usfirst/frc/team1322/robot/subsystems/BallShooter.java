package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallShooter extends Subsystem {

	Servo ballBlocker;
	CANTalon  ballShooter, ballShooter2;
	final static double[] PIDDefault = {0, 0, 0, 0.0025}; // Set for default {P, I, D, F} settings 
	private static final double defError = 100;
	boolean pidModeSet = false;
    
	/*********************************************
	 * Ball Shooter Constructor
	 * This subsystem will set the second shooter motor to follow the first that way the 
	 * first can be set to automated internal control
	 */
	public BallShooter(){
		ballShooter = new CANTalon(RobotMap.CAN_SHT);	
		ballShooter2 = new CANTalon(RobotMap.CAN_SHOOT_2);
		ballBlocker = new Servo(RobotMap.ballBlocker);
		
		ballShooter.setPID(PIDDefault[0], PIDDefault[1], PIDDefault[2]);
		ballShooter.setF(PIDDefault[3]);
		
		ballShooter2.changeControlMode(TalonControlMode.Follower);
		ballShooter2.set(ballShooter.getDeviceID());
		ballShooter2.reverseOutput(true);
	}
	
	public void enablePID(){
		ballShooter.changeControlMode(TalonControlMode.Speed);
		ballShooter.set(0);
		pidModeSet = true;
	}
	
	public void disablePID(){
		ballShooter.changeControlMode(TalonControlMode.PercentVbus);
		ballShooter.set(0);
		pidModeSet = false;
	}
	
	public void set(double input){
		if (input > 2 && !pidModeSet){
			input = 0;
		}
		else if (input < 0 && pidModeSet){
			input = 0;
		}
		ballShooter.set(input);
	}
	
	public boolean errorInLim(){
		return Math.abs(ballShooter.getError()) <= defError;
	}
	public boolean errorInLim(double error){
		return Math.abs(ballShooter.getError()) <= error;
	}
	
	public void openBallBlock(boolean set){
		ballBlocker.setAngle(set ? 180 : 120);
	}

    public void initDefaultCommand() {
    }
}

