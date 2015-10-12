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
 * Subsystem that exposes an interface for the drive train.
 */
public class DriveTrain extends Subsystem {

  private final CANJaguar leftMotor;
  private final CANJaguar rightMotor;
  private final AnalogInput rangeFinder;

  private final GyroITG3200 gyroscope;

  /**
   * Initializes the motor controllers for the drive train, the range finder, and the gyroscope.
   * TODO make this class a singleton
   */
  public DriveTrain() {
    leftMotor = new CANJaguar(RobotMap.LEFT_MOTOR.value);
    rightMotor = new CANJaguar(RobotMap.RIGHT_MOTOR.value);

    rangeFinder = new AnalogInput(RobotMap.RANGE_FINDER.value);

    gyroscope = new gyro.GyroITG3200(I2C.Port.kOnboard);
    gyroscope.initialize();
  }

  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

  /**
   * Sets the left and right speeds of the drive train.
   * @param left left side speed in the range [-1,1]
   * @param right right side speed in the range [-1,1]
   */
  public void drive(double left, double right) {
    // TODO constrain left and right
    
    // TODO need calls to setPercentMode? 
    leftMotor.set(-left);
    rightMotor.set(right);
  }

  /**
   * Read the x rotation of the gyroscope.
   * @return the x rotation in the gyro's LSB format
   * @see GyroITG3200#getRotationX()
   */
  public double getXRotation() {
    return gyroscope.getRotationX();
  }

  /**
   * Read the y rotation of the gyroscope.
   * @return the y rotation in the gyro's LSB format
   * @see GyroITG3200#getRotationY()
   */
  public double getYRotation() {
    return gyroscope.getRotationY();
  }

  /**
   * Read the z rotation of the gyroscope.
   * @return the z rotation in the gyro's LSB format
   * @see GyroITG3200#getRotationZ()
   */
  public double getZRotation() {
    return gyroscope.getRotationZ();
  }

  /**
   * Read the distance to a surface in front of the robot, as determined by the range finder.
   * @return the range in inches
   */
  public double getRange() {
    // XXX make a more readable conversion factor
    return (rangeFinder.pidGet() * 100 * (5.0 / 4.88)) / 2.54;
  }
  
  /**
   * Writes relevant data about the drive train to the SmartDashboard.
   */
  public void log() {
    SmartDashboard.putNumber("Range Finder", getRange());

    SmartDashboard.putNumber("X rot", getXRotation());
    SmartDashboard.putNumber("Y rot", getYRotation());
    SmartDashboard.putNumber("Z rot", getZRotation());
  }

}
