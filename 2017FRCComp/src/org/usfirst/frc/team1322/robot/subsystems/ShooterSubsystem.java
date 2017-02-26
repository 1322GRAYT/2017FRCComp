package org.usfirst.frc.team1322.robot.subsystems;

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
		
	Servo leftYSev, rightYSev, leftXSev, rightXSev;
	
	CANTalon ballAgi, ballAgi2, ballLift, ballShtL, ballShtR, ballIT;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShooterSubsystem(){
		leftYSev = new Servo(RobotMap.BALL_Y_L);
		rightYSev = new Servo(RobotMap.BALL_Y_R);
		
		leftXSev = new Servo(RobotMap.BALL_X_L);
		rightXSev = new Servo(RobotMap.BALL_X_R);
		
		ballAgi = new CANTalon(RobotMap.CAN_BALL_AGI);
		ballLift = new CANTalon(RobotMap.CAN_BALL_LIFT);
		
		ballShtL = new CANTalon(RobotMap.CAN_SHT_L);
		ballShtR = new CANTalon(RobotMap.CAN_SHT_R);
		
		ballIT = new CANTalon(RobotMap.CAN_BALL_IT);
		ballAgi2 = new CANTalon(RobotMap.CAN_BALL_AGI2);
	}
	
	public void run(double y, double x){
    	if(y > .2){
    		up();
    	}else if(y < -.2){
    		down();
    	}
    	
    	if(x > .2){
    		left();
    	}else if(x < -.2){
    		right();
    	}
	}
	
	public void up(){
		double lPos = leftYSev.getPosition();
		double rPos = rightYSev.getPosition();
		lPos = lPos + .1;
		rPos = rPos - .1;
		leftYSev.setPosition(lPos);
		rightYSev.setPosition(rPos);
		leftYSev.setDisabled();
		rightYSev.setDisabled();
	}
	
	public void down(){
		double lPos = leftYSev.getPosition();
		double rPos = rightYSev.getPosition();
		lPos = lPos - .01;
		rPos = rPos + .01;		
		leftYSev.setPosition(lPos);
		rightYSev.setPosition(rPos);
		leftYSev.setDisabled();
		rightYSev.setDisabled();
	}
	
	public void left(){
		double lPos = leftXSev.getPosition();
		double rPos = rightXSev.getPosition();
		lPos = lPos - .1;
		rPos = rPos + .1;		
		leftXSev.setPosition(lPos);
		rightXSev.setPosition(rPos);
		leftXSev.setDisabled();
		rightXSev.setDisabled();
	}
	
	public void right(){
		double lPos = leftXSev.getPosition();
		double rPos = rightXSev.getPosition();
		lPos = lPos + .1;
		rPos = rPos - .1;
		leftXSev.setPosition(lPos);
		rightXSev.setPosition(rPos);
		leftXSev.setDisabled();
		rightXSev.setDisabled();
	}
	
	public double currentPower = .75;
			
	public void powerChanger(boolean up, boolean down){
		if(up){
			currentPower = currentPower + .1;
		}else if(down){
			currentPower = currentPower - .1;
		}
	}

	public void ballSystem(double run){
				
		if(run > 0){
			ballShtL.set(-currentPower);
			ballShtR.set(currentPower);
			
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ballAgi.set(1);
			ballLift.set(100);
			ballAgi2.set(-100);
		}else if(run < 0){
			ballShtL.set(.75);
			ballShtR.set(-.75);
			ballAgi.set(-.5);
			ballLift.set(-100);
			ballAgi2.set(100);
			
		}else{
			ballAgi.set(0);
			ballLift.set(0);
			ballShtL.set(0);
			ballShtR.set(0);
			ballAgi2.set(0);
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
	
    public void initDefaultCommand(){
    	setDefaultCommand(new TC_Shooter());
    }
}

