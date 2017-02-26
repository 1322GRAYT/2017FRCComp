package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import org.usfirst.frc.team1322.robot.subsystems.WinchSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TC_Winch extends Command {

    public TC_Winch() {
    	requires(Robot.WinchSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.WinchSubsystem.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	boolean up = Robot.oi.AuxStick.Buttons.Y.current;
    	boolean down = Robot.oi.AuxStick.Buttons.A.current;
    	Robot.WinchSubsystem.run(up, down);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.WinchSubsystem.brake(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
