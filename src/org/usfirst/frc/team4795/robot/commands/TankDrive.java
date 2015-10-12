package org.usfirst.frc.team4795.robot.commands;


import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command that controls the drive train using operator inputs in a tank-like fashion
 */
public class TankDrive extends Command {

  /**
   * Prepares a new command for execution.
   */
  public TankDrive() {
    requires(Robot.drivetrain);
  }

  protected void initialize() {}

  protected void execute() {
    double throttle = 1 - ((Robot.operatorInterface.getLeftJoy().getThrottle() + 1) / 2.0);
    SmartDashboard.putNumber("multiplier", throttle);

    Robot.drivetrain.drive(Robot.operatorInterface.getLeftJoy().getY() * throttle,
        Robot.operatorInterface.getRightJoy().getY() * throttle);
    
    // update the SmartDashboard data concerning the drive train
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
  
}
