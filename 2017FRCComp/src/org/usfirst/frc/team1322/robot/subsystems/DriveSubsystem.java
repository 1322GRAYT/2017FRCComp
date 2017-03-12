package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_DriveSystem;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon m_CAN_D_FL, m_CAN_D_RL, m_CAN_D_FR, m_CAN_D_RR;
    private boolean autonActivated;    
    
    public DriveSubsystem(){
    	m_CAN_D_FL = new CANTalon(RobotMap.CAN_D_FL);
    	m_CAN_D_RL = new CANTalon(RobotMap.CAN_D_RL);
    	m_CAN_D_FR = new CANTalon(RobotMap.CAN_D_FR);
    	m_CAN_D_RR = new CANTalon(RobotMap.CAN_D_RR);
    	DriveSystem = new RobotDrive(m_CAN_D_FL, m_CAN_D_RL,
    								 m_CAN_D_FR, m_CAN_D_RR);
    	
    	LiveWindow.addActuator("Robot Drive", "Front Left", m_CAN_D_FL);
    	LiveWindow.addActuator("Robot Drive", "Rear Left", m_CAN_D_RL);
    	LiveWindow.addActuator("Robot Drive", "Front Right", m_CAN_D_FR);
    	LiveWindow.addActuator("Robot Drive", "Rear Right", m_CAN_D_RR);
    }
     
    public void ArcadeDrive(double forwardPower, double turnPower) {
    	DriveSystem.arcadeDrive(forwardPower, turnPower);
    	System.out.println(forwardPower);
    }
    
	public void Stop() {
		ArcadeDrive(0, 0);
	}
	
    @SuppressWarnings("unused")
    public int getEncoderPosition() {    	
    	return m_CAN_D_RR.getEncPosition();
    }
    
    public double getScaledEncoderPosition(){
    	return (double)getEncoderPosition() * 458.3;
    }

    public void setSafety(boolean safety){
    	autonActivated = safety;
    	DriveSystem.setSafetyEnabled(safety);
    }
    
    public void setPID(double Kp, double Ki, double Kd){
    	m_CAN_D_RR.setPID(Kp, Ki, Kd);
    }
    
    public void setAutonMode(){
    	setSafety(false);
    }
    
    public void deactivateAutonMode(){
    	setSafety(true);
    	Stop();
    }
    
    public void resetEncoder() {
    	m_CAN_D_RR.setEncPosition(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TC_DriveSystem());
    }

	public void setPosition(double driveToPosition) {
		if (autonActivated){
			ArcadeDrive(.75, 0);
		}	
	}
	
	public double getVoltageLDrive(){
		return m_CAN_D_FL.getOutputVoltage();
	}
	
	public double getVoltageRDrive(){
		return m_CAN_D_FR.getOutputVoltage();
	}

	public int getError() {
		return (int)m_CAN_D_RR.getError();
	}
	
}