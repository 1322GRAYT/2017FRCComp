package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

enum DoorPosition {Open, Close};
public class GearSubsystem extends Subsystem {

    Servo GearDoorR, GearDoorL; 
    
    public GearSubsystem(){
    	GearDoorR = new Servo(RobotMap.GEAR_DOOR_R);
    	GearDoorL = new Servo(RobotMap.GEAR_DOOR_L);
    }
        
    public void open(){
		GearDoorR.setAngle(0);
		GearDoorL.setAngle(180);
		SmartDashboard.putBoolean("GearDoor", true);
    }

    public void close(){
		GearDoorR.setAngle(180);
		GearDoorL.setAngle(0);
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
    }
}

