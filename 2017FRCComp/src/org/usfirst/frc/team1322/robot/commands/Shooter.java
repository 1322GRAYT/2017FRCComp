package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	
    	
    	Robot.ShooterSubsystem.run(Robot.oi.AuxStick.LeftStick.Y, Robot.oi.AuxStick.LeftStick.X);
    	double run = Robot.oi.AuxStick.Triggers.Combined;
    	Robot.ShooterSubsystem.ballSystem(run);
    	
    	boolean in = Robot.oi.AuxStick.DPad.Up;
    	boolean out = Robot.oi.AuxStick.DPad.Down;
    	Robot.ShooterSubsystem.ballIntake(in, out);
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
