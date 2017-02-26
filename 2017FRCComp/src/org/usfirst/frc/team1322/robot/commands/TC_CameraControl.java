package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TC_CameraControl extends Command {
	
    public TC_CameraControl() {
    	requires(Robot.CameraSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	boolean up = Robot.oi.AuxStick.DPad.Up;
    	boolean down = Robot.oi.AuxStick.DPad.Down;
    	boolean left = Robot.oi.AuxStick.DPad.Left;
    	boolean right = Robot.oi.AuxStick.DPad.Right;
    	//Robot.CameraSystem.run(up, down, left, right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.CameraSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
