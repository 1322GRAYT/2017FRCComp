package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_Gears;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

enum DoorPosition {Open, Close};
public class GearSubsystem extends Subsystem {

    Servo GrDrR, GrDrL; 
    
    public GearSubsystem(){
    	GrDrR = new Servo(RobotMap.GEAR_DOOR_R);
    	GrDrL = new Servo(RobotMap.GEAR_DOOR_L);
    }
        
    public void open(){
		GrDrR.setAngle(0);
		GrDrL.setAngle(180);
		SmartDashboard.putBoolean("GearDoor", true);
    }

    public void close(){
		GrDrR.setAngle(180);
		GrDrL.setAngle(0);
		SmartDashboard.putBoolean("GearDoor", false);
    }
    
    public void run(DoorPosition Position){
    	switch (Position){
		case Close:
			close();
			break;
		case Open:
			open();
			break;
		default:
			close();
			break;
    	}
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new TC_Gears());
    	
    }
}
