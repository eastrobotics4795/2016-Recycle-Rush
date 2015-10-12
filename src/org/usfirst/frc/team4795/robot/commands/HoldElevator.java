package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that maintains the position of the elevator through PID control.
 */
public class HoldElevator extends Command {

  /**
   * Prepares a new command for execution.
   */
  public HoldElevator() {
    requires(Robot.elevator);
  }

  protected void initialize() {
    // begin controlling the speed of the elevator through the encoder
    // XXX random PID values?
    Robot.elevator.startSpeedMode(-0.5, -0.05, 0);
  }

  protected void execute() {
    // XXX using small value in place of zero
    Robot.elevator.setSpeed(0.001);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {}
  
}
