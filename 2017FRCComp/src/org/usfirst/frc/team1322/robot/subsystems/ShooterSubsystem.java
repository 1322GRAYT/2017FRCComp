package org.usfirst.frc.team1322.robot.subsystems;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_Shooter;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
		
	Servo ballBlocker;
	CANTalon ballAgitator, ballAgitator2, ballShooter, ballShooter2, ballIntake;
	
	public ShooterSubsystem(){
		ballBlocker = new Servo(RobotMap.ballBlocker);
		ballAgitator = new CANTalon(RobotMap.CAN_BALL_AGI);
		ballAgitator2 = new CANTalon(RobotMap.CAN_BALL_AGI2);
		ballShooter = new CANTalon(RobotMap.CAN_SHT);	
		ballShooter2 = new CANTalon(RobotMap.CAN_SHT_L);
		ballIntake = new CANTalon(RobotMap.CAN_BALL_IT);
		ballShooter2.reverseOutput(true);
	}
	
			
	public void ShootBalls(){
		ballBlocker.setAngle(180);
		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		runShooter(1);
		try {TimeUnit.MILLISECONDS.sleep(250);} 
		catch (InterruptedException e) {e.printStackTrace();}
		runBallAgi(.27);
	}
	
	public void BackFeed(){
		runShooter(-0.5);
		runBallAgi(-.50);
	}
	
	public void StopShooter(){
		ballBlocker.setAngle(120);
		stopShooter();
		stopBallAgi();
	}
	
	public void ballIntake(boolean in, boolean out){
		if(in){
			ballIntake.set(-100);
		}else if(out){
			ballIntake.set(100);
		}else{
			ballIntake.set(0);
		}
	}
	
	private void runBallAgi(double power){
		ballAgitator.set(power);
		ballAgitator2.set(power);
	}
	
	private void runShooter(double power){
		ballShooter.set(power);
		ballShooter2.set(power);
	}
	
	private void stopShooter(){
		ballShooter.set(0);
		ballShooter2.set(0);
	}
	
	private void stopBallAgi(){
		ballAgitator.set(0);
		ballAgitator2.set(0);
	}
	
    public void initDefaultCommand(){
    	setDefaultCommand(new TC_Shooter());
    }
}

