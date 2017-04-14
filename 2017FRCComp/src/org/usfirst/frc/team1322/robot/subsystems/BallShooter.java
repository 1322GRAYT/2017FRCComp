package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BallShooter extends Subsystem {

	Servo ballBlocker;
	CANTalon  ballShooter, ballShooter2;
	final static double[] PIDDefault = {.6, 0, .5, 0.04}; // Set for default {P, I, D, F} settings 
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
		
		ballShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
		ballShooter.setPID(PIDDefault[0], PIDDefault[1], PIDDefault[2], 
				PIDDefault[3], 0, 0, 0);
		
		ballShooter2.changeControlMode(TalonControlMode.Follower);
		ballShooter2.set(ballShooter.getDeviceID());
	}
	
	public void enablePID(){
		ballShooter.configNominalOutputVoltage(+0.0f, -0.0f);
		ballShooter.configPeakOutputVoltage(+12.0f, -12.0f);
		ballShooter.changeControlMode(TalonControlMode.Speed);
		ballShooter.set(0);
		pidModeSet = true;
	}
	
	public void disablePID(){
		ballShooter.changeControlMode(TalonControlMode.PercentVbus);
		ballShooter.set(0);
		pidModeSet = false;
	}
	
	public double getV(){
		return ballShooter.getSpeed();
	}
	
	public void set(double input){
		if (input > 2 && !pidModeSet){
			input = 0;
		}
		else if (input < 0 && pidModeSet){
			input = 0;
		}
		ballShooter.set(input);
		SmartDashboard.putNumber("ActualInput", input);
		SmartDashboard.putNumber("ShootVoltage", ballShooter.getOutputVoltage());
	}
	
	public boolean errorInLim(){
		double recError = Math.abs(ballShooter.getError());
		SmartDashboard.putNumber("ErrorShooter", recError);
		return  recError <= defError;
	}
	public boolean errorInLim(double error){
		double recError = Math.abs(ballShooter.getError());
		SmartDashboard.putNumber("ErrorShooter", recError);
		return  recError <= error;
	}
	
	public void openBallBlock(boolean set){
		ballBlocker.setAngle(set ? 180 : 120);
	}

    public void initDefaultCommand() {
    }
}

