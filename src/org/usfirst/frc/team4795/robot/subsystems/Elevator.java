package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.HoldElevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem that exposes an interface for the elevator.
 */
public class Elevator extends Subsystem {
  
  private final CANJaguar winchMotor;

  /**
   * Initializes the motor controller for the elevator.
   * TODO make this class a singleton
   */
  public Elevator() {
    winchMotor = new CANJaguar(RobotMap.WINCH_MOTOR.value);
    
    // set the elevator motor to resist movement when not active
    winchMotor.configNeutralMode(CANJaguar.NeutralMode.Brake);
  }

  public void initDefaultCommand() {
    // maintain the elevator's position when not executing other commands
    setDefaultCommand(new HoldElevator());
  }
  
  /**
   * Set the elevator motor controller to use the encoder and PID system for position control.
   * In this mode a call to setPosition should be a number of rotations.
   * @param p the initial proportional component for the PID system
   * @param i the initial integral component for the PID system
   * @param d the initial derivative component for the PID system
   */
  public void startPositionMode(double p, double i, double d) {
    winchMotor.disableControl();
    winchMotor.setPositionMode(CANJaguar.kQuadEncoder, 2048, p, i, d);
    winchMotor.enableControl();
  }

  /**
   * Set the elevator motor controller to use the encoder and PID system for speed control.
   * In this mode a value fed to setPosition should be in rotations per minute.
   * @param p the initial proportional component for the PID system
   * @param i the initial integral component for the PID system
   * @param d the initial derivative component for the PID system
   */
  public void startSpeedMode(double p, double i, double d) {
    winchMotor.disableControl();
    winchMotor.setSpeedMode(CANJaguar.kQuadEncoder, 2048, p, i, d);
    winchMotor.enableControl();
  }

  /**
   * Set the elevator motor controller to feed the motor a percentage of the bus voltage.
   * In this mode a value fed to setPosition should be in the range [-1.0, 1.0].
   */
  public void startPercentMode() {
    winchMotor.disableControl();
    winchMotor.setPercentMode();
    winchMotor.enableControl();
  }

  /**
   * Sets the output value of the motor controller.
   * The meaning of this value changes depending on the mode that the controller is in.
   * @see CANTalon#set(double)
   * @param speed the output value of the motor controller
   */
  public void setSpeed(double speed) {
    winchMotor.set(speed);
  }
  
  /**
   * Reads the position of the motor through the motor controller.
   * TODO find what the units of this are
   * @return the position of the motor, according to the controller
   */
  public double getPosition() {
    return winchMotor.getPosition();
  }

  /**
   * Writes relevant data about the elevator to the SmartDashboard.
   */
  public void log() {
    SmartDashboard.putNumber("encoder", winchMotor.getPosition());
  }

}

