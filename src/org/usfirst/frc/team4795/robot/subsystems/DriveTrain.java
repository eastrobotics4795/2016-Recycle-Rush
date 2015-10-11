package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import gyro.ADXL345_I2C_SparkFun;
import gyro.GyroITG3200;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	private CANJaguar leftMotor, rightMotor; 
	private AnalogInput rangeFinder;
	
	
	private ADXL345_I2C_SparkFun m_accel;
	private GyroITG3200 m_gyro;
	
	public DriveTrain(){
		super();
		
		leftMotor = new CANJaguar(RobotMap.leftMotor);
		rightMotor = new CANJaguar(RobotMap.rightMotor);
		
		rangeFinder = new AnalogInput(0);
		
		m_accel = new gyro.ADXL345_I2C_SparkFun(I2C.Port.kOnboard, Accelerometer.Range.k16G);
	    m_gyro = new gyro.GyroITG3200(I2C.Port.kOnboard);
	    m_gyro.initialize();
		
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    
    
    
    /**
	 * Tank style driving for the DriveTrain. 
	 * @param left Speed in range [-1,1]
	 * @param right Speed in range [-1,1]
	 */
    public void drive(double left, double right){
    	leftMotor.set(-left);
		rightMotor.set(right);
    }
    
    /**
     * get x rotation from gyro
     * @return
     */
    public double getXRotation(){
    	return m_gyro.getRotationX();
    }
    public double getYRotation() {
    	return m_gyro.getRotationY();
    }
    public double getZRotation() {
    	return m_gyro.getRotationZ();
    }
    /*
     * get the range value from the range finder
     * 
     * @return the value in inches 
     */
    public double getRange(){
    	return (rangeFinder.pidGet() * 100 * (5.0/4.88)) / 2.54;
    }
    
    public void log(){
    	SmartDashboard.putNumber("Range Finder", getRange());
    	
    	SmartDashboard.putNumber("X rot" ,getXRotation());
    	SmartDashboard.putNumber("Y rot" ,getYRotation());
    	SmartDashboard.putNumber("Z rot" ,getZRotation());
    }
    
}

