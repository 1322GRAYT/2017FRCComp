package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_DriveSystem;
import com.ctre.CANTalon;
import org.usfirst.frc.team1322.robot.utils.BNO055;
import org.usfirst.frc.team1322.robot.utils.BNO055.CalData;
import org.usfirst.frc.team1322.robot.utils.BNO055.reg_t;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon m_CAN_D_FL, m_CAN_D_RL, m_CAN_D_FR, m_CAN_D_RR;
    private int encoderValue;
    private boolean autonActivated;
    private static BNO055 imu;
    
    
    public DriveSubsystem(){
    	imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS,
				BNO055.vector_type_t.VECTOR_EULER);
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
    	encoderValue = m_CAN_D_RR.getEncPosition();
    }
    
    public int getEncoderPosition() {
    	encoderValue = m_CAN_D_RR.getEncPosition();
    	
    	return encoderValue;
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
    	encoderValue = 0;
    	m_CAN_D_RR.setEncPosition(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TC_DriveSystem());
    }

	public void setPosition(double driveToPosition) {
		// TODO Auto-generated method stub
		if (autonActivated){
			ArcadeDrive(.75, 0);
		}
		
	}

	public int getError() {
		return (int)m_CAN_D_RR.getError();
	}
	
	//EVERYTHING BENEATH THIS IS FOR THE GYRO
	
    /**
	 * The heading of the sensor (x axis) in continuous format. Eg rotating the
	 *   sensor clockwise two full rotations will return a value of 720 degrees.
	 *
	 * @return heading in degrees
     */
    public double getHeading() {
    	return imu.getHeading();
    }
    
    /**
     * Gets a vector representing the sensors position (heading, roll, pitch).
	 * heading:    0 to 360 degrees
	 * roll:     -90 to +90 degrees
	 * pitch:   -180 to +180 degrees
	 *
	 * For continuous rotation heading (doesn't roll over between 360/0) see
	 *   the getHeading() method.
	 *
	 * @return a vector [heading, roll, pitch]
	 */
    public double[] getVector() {
    	return imu.getVector();
    }
    
	/**
	 * @return true if the IMU is found on the I2C bus
	 */
	public boolean isSensorPresent() {
		return imu.isSensorPresent();
	}

	/** 
	 * @return true when the IMU is initialized.
	 */
	public boolean isInitialized() {
		return imu.isInitialized();
	}
	
	/**
	 * Gets current IMU calibration state.
	 * @return each value will be set to 0 if not calibrated, 3 if fully
	 *   calibrated.
	 */
	public BNO055.CalData getCalibration() {
		return imu.getCalibration();
	}
	
	/**
	 * Returns true if all required sensors (accelerometer, magnetometer,
	 *   gyroscope) in the IMU have completed their respective calibration
	 *   sequence.
	 * @return true if calibration is complete for all sensors required for the
	 *   mode the sensor is currently operating in. 
	 */
	public boolean isCalibrated() {
		return imu.isCalibrated();
	}

}
