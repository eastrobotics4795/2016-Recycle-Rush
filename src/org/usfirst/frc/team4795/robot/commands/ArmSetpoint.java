package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that moves the arm to a specific position.
 */
public class ArmSetpoint extends Command {

  private final double setPoint;

  boolean isFinished = false;

  /**
   * Uses setPoint as a reference point to move the arm.
   * TODO find the upper bound of this value
   * @param setPoint a reference value where zero is fully open
   */
  public ArmSetpoint(double setPoint) {
    requires(Robot.arm);
    this.setPoint = setPoint;
  }

  protected void initialize() {}

  protected void execute() {
    double pos = Robot.arm.getPosition();
    // finish executing when the arm is within tolerance
    if (Math.abs(pos - setPoint) < 20) {
      isFinished = true;
    } else if (pos > setPoint) {
      Robot.arm.setSpeed(0.5);
    } else if (pos < setPoint) {
      Robot.arm.setSpeed(-0.5);
    }
    
    // update the SmartDashboard data concerning the arm 
    Robot.arm.log();
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
