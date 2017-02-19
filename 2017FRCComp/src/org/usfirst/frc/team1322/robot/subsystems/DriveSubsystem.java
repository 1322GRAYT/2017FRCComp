package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TeleopDriveSystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon m_CAN_D_FL, m_CAN_D_RL, m_CAN_D_FR, m_CAN_D_RR;
    private Servo shifterL, shifterR;
    private int encoderValue;
    private int setPosition;
    private boolean autonActivated;
    private final static double scaleFactor = 1.0;
    
    
    public DriveSubsystem(){
    	shifterL = new Servo(RobotMap.SHIFTER_L);
    	shifterR = new Servo(RobotMap.SHIFTER_R);
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
    
	public void Shift(boolean high, boolean low){
		
	}
	
    private void updateEncoder() {
    	encoderValue = m_CAN_D_FL.getEncPosition();
    }
    
    public int getEncoderPosition() {
    	updateEncoder();
    	return encoderValue;
    }

    public void setSafety(boolean safety){
    	autonActivated = safety;
    	DriveSystem.setSafetyEnabled(safety);
    }
    
    public void setPID(double Kp, double Ki, double Kd){
    	m_CAN_D_FL.setPID(Kp, Ki, Kd);
    }
    
    public void setAutonMode(){
    	setSafety(false);
    	m_CAN_D_FL.setControlMode(TalonControlMode.Position.value);
    	m_CAN_D_FL.set(0);
    	m_CAN_D_RL.setControlMode(TalonControlMode.Follower.value);
    	m_CAN_D_RL.set(m_CAN_D_FL.getDeviceID());
    	m_CAN_D_FR.setControlMode(TalonControlMode.Follower.value);
    	m_CAN_D_FR.set(m_CAN_D_FL.getDeviceID());
    	m_CAN_D_RR.setControlMode(TalonControlMode.Follower.value);
    	m_CAN_D_RR.set(m_CAN_D_FL.getDeviceID());
    }
    
    public void deactivateAutonMode(){
    	m_CAN_D_FL.setControlMode(TalonControlMode.Voltage.value);
    	m_CAN_D_FR.setControlMode(TalonControlMode.Voltage.value);
    	m_CAN_D_RL.setControlMode(TalonControlMode.Voltage.value);
    	m_CAN_D_RR.setControlMode(TalonControlMode.Voltage.value);
    	setSafety(true);
    	Stop();
    }
    
    public void resetEncoder() {
    	encoderValue = 0;
    	m_CAN_D_FL.setEncPosition(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDriveSystem());
    }

	public void setPosition(double driveToPosition) {
		// TODO Auto-generated method stub
		setPosition = (int)(driveToPosition / scaleFactor);
		if (autonActivated) m_CAN_D_FL.set(setPosition);
		
	}

	public int getError() {
		return (int)m_CAN_D_FL.getError();
	}

}
