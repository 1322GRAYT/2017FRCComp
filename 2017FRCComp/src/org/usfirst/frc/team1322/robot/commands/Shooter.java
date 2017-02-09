package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shooter extends Command {

    public Shooter() {
    	requires(Robot.ShooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	boolean up = false;
    	boolean down = false;
    	if(Robot.oi.AuxStick.LeftStick.Y > 0){
    		up = true;
    		down = false;
    	}else if(Robot.oi.AuxStick.LeftStick.Y < 0 ){
    		up = false;
    		down = true;
    	}else{
    		up = false;
    		down = true;
    	}
    	Robot.ShooterSubsystem.run(up, down);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
