package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.can.CANMessageNotAllowedException;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that moves the elevator down at a fixed rate while active.
 */
public class ElevatorDown extends Command {
  
  /**
   * Prepares a new command for execution.
   */
  public ElevatorDown() {
    requires(Robot.elevator);
  }

  protected void initialize() {
    Robot.elevator.startPercentMode();
  }

  protected void execute() {
    try {
      Robot.elevator.setSpeed(0.5);
    } catch (CANMessageNotAllowedException e) {
      e.printStackTrace();
    }
    
    // update the SmartDashboard data concerning the elevator
    Robot.elevator.log();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {}
  
}
