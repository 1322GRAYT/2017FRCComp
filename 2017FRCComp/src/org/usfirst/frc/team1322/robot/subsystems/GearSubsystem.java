package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearSubsystem extends Subsystem {

	Compressor c = new Compressor(0);
	Solenoid leftPiston = new Solenoid(1);
	Timer wait = new Timer();
   
    public GearSubsystem(){
    	
    }
        
    public void eject(){
		leftPiston.set(true);
		SmartDashboard.putBoolean("GearPistonsExtended", true);
    }

    public void close(){
		leftPiston.set(false);
		SmartDashboard.putBoolean("GearPistonsExtended", false);
    }
    
    public void run(){/*
    	wait.reset();
    	wait.start();
    	eject();
    	wait.start();
    	if(wait.get() > 1){
    		close();
    	}*/
    }
    
    public void initDefaultCommand() {
    }
}

