package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that moves the arm at a specific speed while active.
 */
public class SpinArm extends Command {

  private final double speed;

  /**
   * Uses speed as the speed to move the arm at.
   * @param speed a speed in the range -1 to 1
   */
  public SpinArm(double speed) {
    // TODO constrain speed
    
    requires(Robot.arm);
    this.speed = speed;
  }

  protected void initialize() {
    // TODO need a startPercentMode here?
  }

  protected void execute() {
    // TODO try-catch needed here?
    Robot.arm.setSpeed(speed);
    
    // update the SmartDashboard data concerning the arm
    Robot.arm.log();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.arm.setSpeed(0);
  }

  protected void interrupted() {
    end();
  }
  
}
