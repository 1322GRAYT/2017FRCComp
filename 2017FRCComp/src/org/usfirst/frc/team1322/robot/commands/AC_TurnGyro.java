package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AC_TurnGyro extends Command {

    private double direction;
	private boolean reset;
	private double kP = .03,
					dZone = .50;

	public AC_TurnGyro(double direction, boolean reset) {
    	requires(Robot.DriveSystem);
    	this.direction = direction;
    	this.reset = reset;
    }

	private double Error(){
		double error = this.direction - Robot.gyro.getAngle();
		SmartDashboard.putNumber("GyroERR", error);
		return error;
	}
	
    private double ValuePass(double in){
    	boolean sign = (in<0);
    	if (Math.abs(in) > dZone) return in;
    	else return (sign?-dZone:dZone);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	if (reset) Robot.gyro.reset();
    	Robot.DriveSystem.setSafety(false);
    	SmartDashboard.putBoolean("GyroCMD", false);
    	Robot.DriveSystem.ArcadeDrive(0, ValuePass(kP*Error()));    	
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSystem.ArcadeDrive(0, ValuePass(kP*Error()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Error()) < 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.ArcadeDrive(0, 0);
    	Robot.DriveSystem.setSafety(true);
    	SmartDashboard.putBoolean("GyroCMD", true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
