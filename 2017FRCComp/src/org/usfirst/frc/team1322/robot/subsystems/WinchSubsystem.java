package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSubsystem extends Subsystem {
	
	private CANTalon m_Winch;
	
	public WinchSubsystem(){
		m_Winch = new CANTalon(RobotMap.CAN_WINCH);
		m_Winch.enableBrakeMode(true);
	}
	
	public void Up(){
		m_Winch.set(1);
	}
	
	public void Down(){
		m_Winch.set(-1);
	}
	
    public void stop(){
    	m_Winch.set(0);
    }
	
    public void initDefaultCommand() {
    }
}

