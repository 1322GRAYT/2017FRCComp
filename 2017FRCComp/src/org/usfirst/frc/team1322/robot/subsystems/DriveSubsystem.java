package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_DriveSystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon m_CAN_D_FL, m_CAN_D_RL, m_CAN_D_FR, m_CAN_D_RR;
    
    final static double EncoderScale = 458.3;
    
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
    
    /**********
     * Arcade Drive teleop mode
     * @param forwardPower	Sets forward power
     * @param turnPower		Sets turn power
     */
    public void ArcadeDrive(double forwardPower, double turnPower) {
    	DriveSystem.arcadeDrive(forwardPower, turnPower);
    	System.out.println(forwardPower);
    }
    
    /**********
     * Sets control mode to disabled to ensure the robot is stopped
     */
	public void Stop() {
		m_CAN_D_FL.changeControlMode(TalonControlMode.Disabled);
		m_CAN_D_FR.changeControlMode(TalonControlMode.Disabled);
		m_CAN_D_RL.changeControlMode(TalonControlMode.Disabled);
		m_CAN_D_RR.changeControlMode(TalonControlMode.Disabled);
	}
	
	public void Restart(){
		m_CAN_D_FL.changeControlMode(TalonControlMode.PercentVbus);
		m_CAN_D_FR.changeControlMode(TalonControlMode.PercentVbus);
		m_CAN_D_RL.changeControlMode(TalonControlMode.PercentVbus);
		m_CAN_D_RR.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	/************
	 * Get Encoder Position
	 * @return Gets Encoder Count
	 */
    public int getEncoderPosition() {    	
    	return m_CAN_D_RR.getEncPosition();
    }
    
    
    /*************
     * Get Scaled Position
     * @return Gets scaled position
     */
    public double getScaledEncoderPosition(){
    	return (double)getEncoderPosition() / EncoderScale;
    }

    /************
     * For Autonomous Mode setup
     * @param safety True will turn it on, False will turn it off
     */
    public void setSafety(boolean safety){
    	DriveSystem.setSafetyEnabled(safety);
    }
    
    /***********
     * Sets up the PID Values
     * @param Kp	Proportional Constant
     * @param Ki	Integral Constant
     * @param Kd	Differential Constant
     */
    public void setPID(double Kp, double Ki, double Kd){
    	m_CAN_D_RR.setPID(Kp, Ki, Kd);
    }
    
    /**********
     * Sets Encoder position to zero
     */
    public void resetEncoder() {
    	m_CAN_D_RR.setEncPosition(0);
    }
	
    /**********
     * Gets the output voltage for the left drive
     * @return	The output Voltage in volts
     */
	public double getVoltageLDrive(){
		return m_CAN_D_FL.getOutputVoltage();
	}
	
	/*********
	 * Gets the output voltage for the right drive 
	 * @return	The output voltage in volts
	 */
	public double getVoltageRDrive(){
		return m_CAN_D_FR.getOutputVoltage();
	}

	/********
	 * Gets current scaled error of the can bus
	 * @return Gets scaled encoder error of control loop  
	 */
	public double getError() {
		return (double)m_CAN_D_RR.getError() / EncoderScale;
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TC_DriveSystem());
    }
}