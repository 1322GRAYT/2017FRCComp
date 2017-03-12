package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_CameraControl;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CameraSubsystem extends Subsystem {
	
	private Servo upDown, leftRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	NetworkTable table;
	private static final double[] defVal = {0,0};
	
	public CameraSubsystem(){
		//upDown = new Servo(RobotMap.upDown);
		leftRight = new Servo(RobotMap.leftRight);
		
		table = NetworkTable.getTable(RobotMap.ContourReport);
	}
	
	public double[] getcenterX(){
		return table.getNumberArray("centerX", defVal);
	}
	
	public double[] getcenterY(){
		return table.getNumberArray("centerY", defVal);
	}
	
	public double[] getheight(){
		return table.getNumberArray("height", defVal);
	}
	
	public double[] getwidth(){
		return table.getNumberArray("width", defVal);
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

