package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AC_GetDistanceFromVision extends Command {

    public AC_GetDistanceFromVision() {
        requires(Robot.CameraSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.CameraSystem.getwidth()[0] <= 15 && Robot.CameraSystem.getwidth()[1] <= 15){
    		//6 Feet or more to go
    		SmartDashboard.putNumber("Reamining Distance: ", 6);
    	}else if(Robot.CameraSystem.getwidth()[0] <= 18 && Robot.CameraSystem.getwidth()[1] <= 18){
    		//5 Feet or more to go
    		SmartDashboard.putNumber("Reamining Distance: ", 5);
    	}else if(Robot.CameraSystem.getwidth()[0] <= 22 && Robot.CameraSystem.getwidth()[1] <= 22){
    		//4 Feet or more to go
    		SmartDashboard.putNumber("Reamining Distance: ", 4);
    	}else if(Robot.CameraSystem.getwidth()[0] <= 26 && Robot.CameraSystem.getwidth()[1] <= 26){
    		//3 Feet or more to go
    		SmartDashboard.putNumber("Reamining Distance: ", 3);
    	}else if(Robot.CameraSystem.getwidth()[0] <= 33 && Robot.CameraSystem.getwidth()[1] <= 33){
    		//2 Feet or more to go
    		SmartDashboard.putNumber("Reamining Distance: ", 2);
    	}else if(Robot.CameraSystem.getwidth()[0] <= 45){
    		//1 Foor or more to go
    		SmartDashboard.putNumber("Reamining Distance: ", 1);
    	}else{
    		SmartDashboard.putNumber("Reamining Distance: ", 999);
    	}
    	
    	SmartDashboard.putNumber("Test: ", Robot.CameraSystem.getwidth()[0]);
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
