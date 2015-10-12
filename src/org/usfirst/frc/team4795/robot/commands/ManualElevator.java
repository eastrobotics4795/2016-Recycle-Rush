package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command that sets the position of the elevator to a value on the SmartDashboard.
 */
public class ManualElevator extends Command {

  /**
   * Prepares a new command for execution.
   */
  public ManualElevator() {
    requires(Robot.elevator);
  }

  protected void initialize() {
    // TODO need a startPositionMode here?
  }

  protected void execute() {
    // this truly sets the position, due to being in position mode; see documentation
    Robot.elevator.setSpeed(SmartDashboard.getNumber("encoderSet", 0));

    // update the SmartDashboard data concerning the elevator
    Robot.elevator.log();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {}
  
}
