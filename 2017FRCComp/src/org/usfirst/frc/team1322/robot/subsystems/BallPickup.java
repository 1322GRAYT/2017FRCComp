package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallPickup extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	CANTalon _BallPickup;
	
	public BallPickup(){
		_BallPickup = new CANTalon(RobotMap.CAN_BALL_IT);
	}
	
	public void In(){
		_BallPickup.set(-1);
	}
	
	public void Out(){
		_BallPickup.set(1);
	}
	
	public void Stop(){
		_BallPickup.set(0);
	}
	
	public void Safe(boolean set){
		_BallPickup.setSafetyEnabled(set);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

