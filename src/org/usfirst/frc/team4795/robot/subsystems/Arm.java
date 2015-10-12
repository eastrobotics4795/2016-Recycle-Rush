package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem that exposes an interface for the grabbing arms on the elevator.
 */
public class Arm extends Subsystem {

  private final CANTalon armMotor;

  /**
   * Initializes the motor controller for the arm.
   * TODO make this class a singleton
   */
  public Arm() {
    armMotor = new CANTalon(RobotMap.ARM_MOTOR.value);
    armMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
  }

  public void initDefaultCommand() {}

  /**
   * Writes relevant data about the arm to the SmartDashboard.
   */
  public void log() {
    SmartDashboard.putNumber("Arm Position", armMotor.getPosition());
  }
  
  /**
   * Sets the output value of the motor controller.
   * The meaning of this value changes depending on the mode that the controller is in.
   * @see CANTalon#set(double)
   * @param speed the output value of the motor controller
   */
  public void setSpeed(double speed) {
    armMotor.set(speed);
  }

  public boolean canGoForward() {
    return !armMotor.isFwdLimitSwitchClosed();
  }

  public boolean canGoReverse() {
    return !armMotor.isRevLimitSwitchClosed();
  }
  
  /**
   * Reads the position of the motor through the motor controller.
   * The meaning of this value changes depending on the mode that the controller is in.
   * @see CANTalon#getPosition()
   * @return the position of the motor, according to the controller
   */
  public double getPosition() {
    return armMotor.getPosition();
  }

  /**
   * Set the zero point of the arm to its current position.
   */
  public void zero() {
    armMotor.setPosition(0);
  }

}

