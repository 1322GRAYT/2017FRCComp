package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterIntake extends Subsystem {

	CANTalon shooterIntake, shooterIntake_2;
	final static double[] PIDDefault = {0, 0, 0, 0.0025}; // Set for default {P, I, D, F} settings 
	boolean pidModeSet = false;
	double defError = 50;
	
	public ShooterIntake(){
		shooterIntake = new CANTalon(RobotMap.CAN_BALL_AGI);
		shooterIntake_2 = new CANTalon(RobotMap.CAN_BALL_AGI2);
		
		shooterIntake.setPID(PIDDefault[0], PIDDefault[1], PIDDefault[2]);
		shooterIntake.setF(PIDDefault[3]);
		
		shooterIntake_2.changeControlMode(TalonControlMode.Follower);
		shooterIntake_2.set(shooterIntake.getDeviceID());
	}
	
	public void enablePID(){
		shooterIntake.changeControlMode(TalonControlMode.Speed);
		shooterIntake.set(0);
		pidModeSet  = true;
	}
	
	public void disablePID(){
		shooterIntake.changeControlMode(TalonControlMode.PercentVbus);
		shooterIntake.set(0);
		pidModeSet = false;
	}
	
	public void set(double input){
		if (input > 2 && !pidModeSet){
			input = 0;
		}
		else if (input < 0 && pidModeSet){
			input = 0;
		}
		shooterIntake.set(input);
	}
	
	public boolean errorInLim(){
		return Math.abs(shooterIntake.getError()) <= defError;
	}
	public boolean errorInLim(double error){
		return Math.abs(shooterIntake.getError()) <= error;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

