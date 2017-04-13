package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BM_BallPickup extends Command {

	
    private boolean In;

	public BM_BallPickup(boolean In) {
        requires(Robot.BallPickup);
        this.In = In;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.BallPickup.Safe(false);
    	if (this.In) Robot.BallPickup.In();
    	else Robot.BallPickup.Out();
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
    	Robot.BallPickup.Safe(true);
    	Robot.BallPickup.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
