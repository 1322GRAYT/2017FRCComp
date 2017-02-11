package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.Gears;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSubsystem extends Subsystem {

    Servo GrDrR, GrDrL;
     
    
    public GearSubsystem(){
    	GrDrR = new Servo(RobotMap.GEAR_DOOR_R);
    	GrDrL = new Servo(RobotMap.GEAR_DOOR_L);
    	
    }
    
    public void open(){
		GrDrR.setAngle(180);
		GrDrL.setAngle(0);
    }

    public void close(){
		GrDrR.setAngle(90);
		GrDrL.setAngle(90);
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

