package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.Robot;
import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
		
	Servo leftYSev, rightYSev, leftXSev, rightXSev;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShooterSubsystem(){
		leftYSev = new Servo(RobotMap.BALL_Y_L);
		rightYSev = new Servo(RobotMap.BALL_Y_R);
		
		leftXSev = new Servo(RobotMap.BALL_X_L);
		rightXSev = new Servo(RobotMap.BALL_X_R);
		
	}
	
	public void run(double y, double x){
		upDown(y);
		leftRight(x);
	}
	
	public void upDown(double y){
		boolean up = false;
    	boolean down = false;
    	if(y > 0){
    		up = true;
    		down = false;
    	}else if(y < 0 ){
    		up = false;
    		down = true;
    	}else{
    		up = false;
    		down = false;
    	}
		
		if(up){
			double lcPos = leftYSev.getPosition();
			double lnPos = leftYSev.getPosition();
			double rcPos = rightYSev.getPosition();
			double rnPos = rightYSev.getPosition();
			if(lcPos < 1){
				lnPos = lcPos + .01;
				rnPos = rcPos + .01;
			}		
			leftYSev.setPosition(lnPos);
			rightYSev.setPosition(rnPos);	
		}else if(down){
			double lcPos = leftYSev.getPosition();
			double lnPos = leftYSev.getPosition();
			double rcPos = rightYSev.getPosition();
			double rnPos = rightYSev.getPosition();
			if(lcPos > -1){
				lnPos = lcPos - .01;
				rnPos = rcPos - .01;
			}		
			leftYSev.setPosition(lnPos);
			rightYSev.setPosition(rnPos);	
		}
	}
	
	public void leftRight(double x){
		boolean up = false;
    	boolean down = false;
    	if(x > 0){
    		up = true;
    		down = false;
    	}else if(x < 0 ){
    		up = false;
    		down = true;
    	}else{
    		up = false;
    		down = false;
    	}
		
		if(up){
			double lcPos = leftXSev.getPosition();
			double lnPos = leftXSev.getPosition();
			double rcPos = rightXSev.getPosition();
			double rnPos = rightXSev.getPosition();
			if(lcPos < 1){
				lnPos = lcPos + .01;
				rnPos = rcPos + .01;
			}		
			leftXSev.setPosition(lnPos);
			rightXSev.setPosition(rnPos);	
		}else if(down){
			double lcPos = leftXSev.getPosition();
			double lnPos = leftXSev.getPosition();
			double rcPos = rightXSev.getPosition();
			double rnPos = rightXSev.getPosition();
			if(lcPos > -1){
				lnPos = lcPos - .01;
				rnPos = rcPos - .01;
			}		
			leftXSev.setPosition(lnPos);
			rightXSev.setPosition(rnPos);	
		}
	}

    public void initDefaultCommand(){
    	setDefaultCommand(new Shooter());
    }
}

