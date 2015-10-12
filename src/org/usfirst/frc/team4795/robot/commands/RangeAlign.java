package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command that uses the range finder and PID control to move to a specific distance from a surface.
 */
public class RangeAlign extends PIDCommand {

  private final double targetOffset;
  
  /**
   * Uses distance as the target offset between the range finder and a surface.
   * @param targetOffset the desired offset
   */
  public RangeAlign(double targetOffset) {
    // XXX random PID values?
    super(-0.02, 0, 0);

    requires(Robot.drivetrain);
    this.targetOffset = targetOffset;
  }

  protected void initialize() {}

  protected void execute() {
    Robot.drivetrain.log();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.drivetrain.drive(0, 0);
  }

  protected void interrupted() {
    end();
  }

  protected double returnPIDInput() {
    return targetOffset - Robot.drivetrain.getRange();
  }

  protected void usePIDOutput(double output) {
    // TODO eliminate calls to signum and multiplication
    if (Math.abs(output) > 0.3) {
      Robot.drivetrain.drive(Math.signum(output) * 0.3, Math.signum(output) * 0.3);
      SmartDashboard.putNumber("speed", Math.signum(output) * 0.3);
    } else {
      Robot.drivetrain.drive(output, output);
      SmartDashboard.putNumber("speed", output);
    }
  }
  
}
