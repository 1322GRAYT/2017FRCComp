package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	
	Servo leftShtSev, rightShtSev;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShooterSubsystem(){
		leftShtSev = new Servo(RobotMap.BALL_AIM_L);
		rightShtSev = new Servo(RobotMap.BALL_AIM_R);
	}
	
	public void run(boolean up, boolean down){
		if(up){
			double lcPos = leftShtSev.getPosition();
			double lnPos = leftShtSev.getPosition();
			double rcPos = rightShtSev.getPosition();
			double rnPos = rightShtSev.getPosition();
			if(lcPos < 1){
				lnPos = lcPos + .01;
				rnPos = rcPos + .01;
			}		
			leftShtSev.setPosition(lnPos);
			rightShtSev.setPosition(rnPos);	
		}else if(down){
			double lcPos = leftShtSev.getPosition();
			double lnPos = leftShtSev.getPosition();
			double rcPos = rightShtSev.getPosition();
			double rnPos = rightShtSev.getPosition();
			if(lcPos < 1){
				lnPos = lcPos - .01;
				rnPos = rcPos - .01;
			}		
			leftShtSev.setPosition(lnPos);
			rightShtSev.setPosition(rnPos);	
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

