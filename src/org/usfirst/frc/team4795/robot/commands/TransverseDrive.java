package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command that controls the transverse wheel using operator inputs.
 */
public class TransverseDrive extends Command {

  /**
   * Prepares a new command for execution.
   */
  public TransverseDrive() {
    requires(Robot.transverseWheel);
  }

  protected void initialize() {}

  protected void execute() {
    double throttle = 1 - ((Robot.operatorInterface.getLeftJoy().getThrottle() + 1) / 2.0);
    SmartDashboard.putNumber("multiplier", throttle);
    
    Robot.transverseWheel.set(Robot.operatorInterface.getLeftJoy().getX() * throttle);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.transverseWheel.set(0);
  }

  protected void interrupted() {
    end();
  }
  
}
