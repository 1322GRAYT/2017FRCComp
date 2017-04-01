package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class BM_WinchControl extends Command {

	boolean m_Up;
	
    public BM_WinchControl(boolean Up) {
    	requires(Robot.WinchSubsystem);
    	this.m_Up=Up;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(m_Up){
    		Robot.WinchSubsystem.Up();
    	}
    	else{
    		Robot.WinchSubsystem.Down();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.WinchSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
