package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that moves the arm into the most open position.
 */
public class HomeArm extends Command {

  private boolean isFinished = false;
  
  /**
   * Prepares a new command for execution.
   */
  public HomeArm() {
    requires(Robot.arm);
  }

  protected void initialize() {}

  protected void execute() {
    // XXX checking in both directions
    if (Robot.arm.canGoForward() && Robot.arm.canGoReverse()) {
      Robot.arm.setSpeed(-0.5);
    } else {
      // set this point as zero in the arm subsystem
      Robot.arm.zero();
      isFinished = true;
    }
  }

  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {
    Robot.arm.setSpeed(0);
  }

  protected void interrupted() {
    end();
  }
  
}
