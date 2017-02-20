package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.Gears;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearSubsystem extends Subsystem {

    Servo GrDrR, GrDrL;
     
    
    public GearSubsystem(){
    	GrDrR = new Servo(RobotMap.GEAR_DOOR_R);
    	GrDrL = new Servo(RobotMap.GEAR_DOOR_L);
    }
    
    public void setup(double angleLeft){
    	GrDrL.setAngle(angleLeft);
    }
    
    public void open(){
		GrDrR.setAngle(0);
		GrDrL.setAngle(180);
    }

    public void close(){
		GrDrR.setAngle(125);
		GrDrL.setAngle(93);
    }
    
    public void run(boolean open, boolean close){
    	if(open){
    		open();
    		
    	}else if (close){
    		close();
    	}
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new Gears());
    	
    }
}

