package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BM_BackfeedShooter extends Command {

    public BM_BackfeedShooter() {
    	requires(Robot.BallShooter);
    	requires(Robot.ShooterIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.BallShooter.set(-0.4);
    	Robot.ShooterIntake.set(-0.5);
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
    	Robot.BallShooter.set(0);
    	Robot.ShooterIntake.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
