package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;


/**
 *
 */
public class BM_GearShift extends InstantCommand {
	
	private boolean high = false;
    public BM_GearShift(boolean high) {
    	requires(Robot.DriveSystem);
    	this.high = high;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(high){Robot.DriveSystem.shiftHigh();}
    	else if (!high){Robot.DriveSystem.shiftLow();}
    }
}
