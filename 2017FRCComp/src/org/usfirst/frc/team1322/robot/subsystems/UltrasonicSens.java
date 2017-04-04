package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSens extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AnalogInput m_Ultrasonic;
	
	public UltrasonicSens() {
		m_Ultrasonic = new AnalogInput(RobotMap.Ultrasonic);
	}
	
	private double getRaw(){
		return m_Ultrasonic.getVoltage();
	}
	
	public double get(){
		return getRaw()/.0098;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

