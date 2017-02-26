package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_Winch;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSubsystem extends Subsystem {
	
	private CANTalon CAN_WINCH;
	
	public WinchSubsystem(){
		CAN_WINCH = new CANTalon(RobotMap.CAN_WINCH);
	}
	
	public void run(boolean up, boolean down){
		if(up){
			brake(false);
			CAN_WINCH.set(100);
		}else if(down){
			brake(false);
			CAN_WINCH.set(-100);
		}else{
			stop();
			brake(true);
		}
	}
	
    public void stop(){
    	CAN_WINCH.set(0);
    }
    
    public void brake(boolean enable){
    	CAN_WINCH.enableBrakeMode(enable);
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new TC_Winch());
    }
}

