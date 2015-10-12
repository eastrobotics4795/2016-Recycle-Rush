package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.MoveElevator;
import org.usfirst.frc.team4795.robot.commands.ResistRotation;
import org.usfirst.frc.team4795.robot.commands.SpinArm;
import org.usfirst.frc.team4795.robot.commands.TransverseDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Binds the controls on the physical interface to the commands that allow control of the robot.
 */
public class OperatorInterface {
  
  private final Joystick leftJoy = new Joystick(0);
  private final Joystick rightJoy = new Joystick(1);

  private final Button elevatorUp = new JoystickButton(leftJoy, 6);
  private final Button elevatorDown = new JoystickButton(leftJoy, 4);

  private final Button armIn = new JoystickButton(rightJoy, 4);
  private final Button armOut = new JoystickButton(rightJoy, 6);

  private final Button leftTrigger = new JoystickButton(leftJoy, 1);
  
  /**
   * Configures the commands to be executed on input.
   */
  public OperatorInterface() {
    elevatorUp.whileHeld(new MoveElevator(0.5));
    elevatorDown.whileHeld(new MoveElevator(-0.5));

    armIn.whileHeld(new SpinArm(0.5));
    armOut.whileHeld(new SpinArm(-0.5));
    
    // make arms moved to fixed places
    // armIn.whenPressed(new HomeArm());
    // armOut.whenPressed(new ArmSetpoint(-570));
    
    leftTrigger.whileHeld(new TransverseDrive());
    leftTrigger.whileHeld(new ResistRotation());
  }

  public Joystick getLeftJoy() {
    return leftJoy;
  }

  public Joystick getRightJoy() {
    return rightJoy;
  }
  
}

