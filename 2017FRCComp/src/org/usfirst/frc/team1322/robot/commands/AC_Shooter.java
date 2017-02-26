package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AC_Shooter extends Command {
	
	Timer ShootClock;
	double EndTime;
	
    public AC_Shooter(double TimeOut) {
        requires(Robot.ShooterSubsystem);
        ShootClock = new Timer();
    	EndTime = TimeOut;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ShootClock.reset();
    	Robot.ShooterSubsystem.ballSystem(.5);
    	ShootClock.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ShootClock.get() > EndTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ShooterSubsystem.ballSystem(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
