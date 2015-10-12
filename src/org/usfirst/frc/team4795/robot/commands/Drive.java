package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that sets the speed of the drive train to specified values while active.
 */
public class Drive extends Command {

  private final double left;
  private final double right;
  
  /**
   * Uses left and right as speeds for the respective sides of the drive train.
   * @param left speed of the left side, in the range -1 to 1
   * @param right speed of the right side, in the range -1 to 1
   */
  public Drive(double left, double right) {
    requires(Robot.drivetrain);
    this.left = left;
    this.right = right;
  }

  protected void initialize() {}

  protected void execute() {
    Robot.drivetrain.drive(left, right);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.drivetrain.drive(0.0, 0.0);
  }

  protected void interrupted() {
    end();
  }
  
}
