package org.usfirst.frc.team1322.robot.subsystems;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team1322.robot.Robot;
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
	
	CANTalon ballAgi, ballAgi2, ballSht, ballShtL, ballIT;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShooterSubsystem(){
		ballBlocker = new Servo(RobotMap.ballBlocker);
		ballAgi = new CANTalon(RobotMap.CAN_BALL_AGI);
		ballAgi2 = new CANTalon(RobotMap.CAN_BALL_AGI2);
		ballSht = new CANTalon(RobotMap.CAN_SHT);	
		ballShtL = new CANTalon(RobotMap.CAN_SHT_L);
		ballIT = new CANTalon(RobotMap.CAN_BALL_IT);
		ballShtL.reverseOutput(true);
	}
	
			
	public void ballSystem(double run){	
		if(run > 0){
			ballBlocker.setAngle(180);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				// TODO WHY AM I USING SLEEP
				e.printStackTrace();
			}
			runShooter(1);
			try {TimeUnit.MILLISECONDS.sleep(250);} 
			catch (InterruptedException e) {e.printStackTrace();}
						
			runBallAgi(.27);
			
		}else if(run < 0){
			runShooter(-0.5);
			runBallAgi(-.50);
		}else{
			ballBlocker.setAngle(120);
			stopShooter();
			stopBallAgi();
		}
	}
	
	public void ballIntake(boolean in, boolean out){
		if(in){
			ballIT.set(-100);
		}else if(out){
			ballIT.set(100);
		}else{
			ballIT.set(0);
		}
	}
	
	private void runBallAgi(double power){
		ballAgi.set(power);
		ballAgi2.set(power);
	}
	
	private void runShooter(double power){
		ballSht.set(power);
		ballShtL.set(power);
	}
	
	private void stopShooter(){
		ballSht.set(0);
		ballShtL.set(0);
	}
	
	private void stopBallAgi(){
		ballAgi.set(0);
		ballAgi2.set(0);
	}
	
    public void initDefaultCommand(){
    	setDefaultCommand(new TC_Shooter());
    }
}

