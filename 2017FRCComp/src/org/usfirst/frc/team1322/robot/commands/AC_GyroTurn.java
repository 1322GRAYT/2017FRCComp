package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AC_GyroTurn extends Command {
	double TurnDirection;
	final static double kP = 0.06;
	
    public AC_GyroTurn(double turn_amount) {
    	requires(Robot.DriveSystem);
    	Robot.gyro.reset();
    }
    
    private double error(){
    	return Robot.gyro.getAngle();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DriveSystem.ArcadeDrive(0, kP * error());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSystem.ArcadeDrive(0, kP * error());
    	SmartDashboard.putNumber("GyroError", error());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return error() < 5;
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