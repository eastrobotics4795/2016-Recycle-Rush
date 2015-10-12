package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that exposes an interface for the transverse wheel.
 */
public class TransverseWheel extends Subsystem {

  private final CANJaguar transverseMotor;

  public TransverseWheel() {
    transverseMotor = new CANJaguar(RobotMap.TRANSVERSE_MOTOR.value);
  }

  public void initDefaultCommand() {}

  /**
   * Reads the position of the motor through the motor controller.
   * The meaning of this value changes depending on the mode that the controller is in.
   * @see CANTalon#getPosition()
   * @return the position of the motor, according to the controller
   */
  public void set(double value) {
    transverseMotor.set(value);
  }

}

