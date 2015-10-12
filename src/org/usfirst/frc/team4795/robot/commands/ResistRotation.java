package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command that prevents the drive train from spinning while active.
 */
public class ResistRotation extends PIDCommand {

  /**
   * Prepares a new command for execution.
   */
  public ResistRotation() {
    super(0, 0, 0);
    requires(Robot.drivetrain);
  }

  protected void initialize() {}

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
    return Robot.drivetrain.getZRotation() - 20;
  }

  protected void usePIDOutput(double output) {
    // updates the SmartDashboard data concerning the PID control
    SmartDashboard.putNumber("PID in", returnPIDInput());
    SmartDashboard.putNumber("PID out", output);
    
    Robot.drivetrain.drive(output, -output);
  }

  protected void execute() {
    // XXX this looks like debug code
    double p = SmartDashboard.getNumber("P", 0);
    double i = SmartDashboard.getNumber("I", 0);
    double d = SmartDashboard.getNumber("D", 0);
    getPIDController().setPID(p, i, d);
  }
  
}
