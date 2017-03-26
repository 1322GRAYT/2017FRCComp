package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterIntake extends Subsystem {

	CANTalon ballAgitator, ballAgitator2;
	boolean pidModeSet = false;
	double defError = 50;
	
	public ShooterIntake(){
		ballAgitator = new CANTalon(RobotMap.CAN_BALL_AGI);
		ballAgitator2 = new CANTalon(RobotMap.CAN_BALL_AGI2);
		
		ballAgitator2.changeControlMode(TalonControlMode.Follower);
		ballAgitator2.set(ballAgitator.getDeviceID());
	}
	
	public void enable(){
		ballAgitator.changeControlMode(TalonControlMode.Speed);
		ballAgitator.set(0);
		pidModeSet  = true;
	}
	
	public void disablePID(){
		ballAgitator.changeControlMode(TalonControlMode.PercentVbus);
		ballAgitator.set(0);
		pidModeSet = false;
	}
	
	public void set(double input){
		if (input > 2 && !pidModeSet){
			input = 0;
		}
		else if (input < 0 && pidModeSet){
			input = 0;
		}
		ballAgitator.set(input);
	}
	
	public boolean errorInLim(){
		return Math.abs(ballAgitator.getError()) <= defError;
	}
	public boolean errorInLim(double error){
		return Math.abs(ballAgitator.getError()) <= error;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

