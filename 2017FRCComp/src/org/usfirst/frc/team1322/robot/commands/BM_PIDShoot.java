package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BM_PIDShoot extends Command {

    public BM_PIDShoot() {
    	requires(Robot.BallShooter);
    	requires(Robot.ShooterIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.BallShooter.enablePID();
    	Robot.ShooterIntake.enablePID();
    	Robot.BallShooter.set(3000);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.BallShooter.errorInLim()){
    		Robot.ShooterIntake.set(500);
    	}
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
