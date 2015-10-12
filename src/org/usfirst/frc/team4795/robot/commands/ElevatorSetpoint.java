package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that moves the elevator to a specific position while active.
 */
public class ElevatorSetpoint extends Command {

  private final double offset;
  private double initPos;

  /**
   * Uses offset as an offset to move the elevator from its current position.
   * TODO find the units of this value
   * @param offset an offset where zero is the current position
   */
  public ElevatorSetpoint(double offset) {
    requires(Robot.elevator);
    this.offset = offset;
  }

  protected void initialize() {
    // begin holding the arm in place using the encoder
    // XXX random PID values?
    Robot.elevator.startPositionMode(-50, 0, 0);
    
    initPos = Robot.elevator.getPosition();
  }

  protected void execute() {
    // TODO constrain this value
    // this truly sets the position due to being in position mode; see documentation
    Robot.elevator.setSpeed(initPos + offset);
    
    // update the SmartDashboard data concerning the elevator
    Robot.elevator.log();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {}
  
}
