package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AC_DriveAuton extends Command {

	Timer DriveClock;
	double EndTime = 5.0, forwardPower = 0, turnPower = 0;
	
    public AC_DriveAuton(double TimeOut, double Forward_Power, double Turn_Power) {
    	requires(Robot.DriveSystem);
    	DriveClock = new Timer();
    	EndTime = TimeOut;
    	forwardPower = Forward_Power;
    	turnPower = Turn_Power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveClock.reset();
    	Robot.DriveSystem.setSafety(false);
    	Robot.DriveSystem.ArcadeDrive(forwardPower, turnPower);
    	DriveClock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return DriveClock.get() > EndTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.ArcadeDrive(0, 0);
    	Robot.DriveSystem.setSafety(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
