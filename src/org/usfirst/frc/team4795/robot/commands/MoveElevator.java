package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.can.CANMessageNotAllowedException;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that moves the elevator at a specific rate while active.
 */
public class MoveElevator extends Command {

  private final double speed;

  /**
   * Uses speed as the speed to move the elevator at.
   * @param speed a speed in the range -1 to 1
   */
  public MoveElevator(double speed) {
    // TODO constrain speed
    
    requires(Robot.elevator);
    this.speed = speed;
  }

  protected void initialize() {
    Robot.elevator.startPercentMode();
  }

  protected void execute() {
    try {
      Robot.elevator.setSpeed(speed);
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
