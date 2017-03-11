package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_CameraControl;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
	
	private Servo upDown, leftRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CameraSubsystem(){
		//upDown = new Servo(RobotMap.upDown);
		leftRight = new Servo(RobotMap.leftRight);
	}
	
	public void up(){
		double cPos = upDown.getPosition();
		double nPos = upDown.getPosition();
		if(cPos < 1){
			nPos = cPos + .01;
		}		
		upDown.setPosition(nPos);	
		
	}

	public void down(){
		double cPos = upDown.getPosition();
		double nPos = upDown.getPosition();
		if(cPos > -1){
			nPos = cPos - .01;
		}		
		upDown.setPosition(nPos);
	}
	
	public void right(){
		double cPos = leftRight.getPosition();
		double nPos = leftRight.getPosition();
		if(cPos < 1){
			nPos = cPos + .01;
		}
		leftRight.setPosition(nPos);
	}
	
	public void left(){
		double cPos = leftRight.getPosition();
		double nPos = leftRight.getPosition();
		if(cPos > -1){
			nPos = cPos - .01;
		}
		
		leftRight.setPosition(nPos);	
	}
	
	public void run(boolean up, boolean down, boolean left, boolean right){
		if(up){
			up();
		}
		if(down){
			down();
		}
		if(left){
			left();
		}
		if(right){
			right();
		}
	}
	
	public void stop(){
		upDown.setDisabled();
		leftRight.setDisabled();
	}

    public void initDefaultCommand() {
        //set the default command for a subsystem here.
        setDefaultCommand(new TC_CameraControl());
    }
}

