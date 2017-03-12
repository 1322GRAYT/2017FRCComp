package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AC_DriveGyroTimed extends Command {

	double	setPosition, 
			RunTime,
			ForwardPower,
			kP = 0.06,
			Error;
	Timer RunTimer;
		
    public AC_DriveGyroTimed(double Runtime, double FwdPow) {
    	requires(Robot.DriveSystem);
        ForwardPower = FwdPow;
        RunTime = Runtime;
        RunTimer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPosition = Robot.imu.getHeading();
    	Robot.DriveSystem.setSafety(false);
    	RunTimer.reset();
    	RunTimer.start();
    	Robot.DriveSystem.ArcadeDrive(ForwardPower, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSystem.ArcadeDrive(ForwardPower, kP * (Robot.imu.getHeading() - setPosition));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RunTimer.get() > RunTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.ArcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}