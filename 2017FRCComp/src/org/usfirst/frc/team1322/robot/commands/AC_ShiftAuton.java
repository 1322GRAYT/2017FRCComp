package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AC_ShiftAuton extends Command {
	
	boolean toggle = false;
	boolean finished = false;
	Timer Clock;
	
    public AC_ShiftAuton(boolean high) {
    	Clock = new Timer();
    	Clock.reset();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveSystem);
    	toggle = high;
    	Clock.start();
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DriveSystem.shiftLow();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (toggle){
    		Robot.DriveSystem.shiftHigh();
    	}else if(!toggle){
    		Robot.DriveSystem.shiftLow();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Clock.get() > 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}