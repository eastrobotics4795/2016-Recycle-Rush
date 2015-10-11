package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Use PID position control to move the elevator to a certain position
 */
public class ElevatorSetpoint extends Command {

	
	
	
	double setPoint;
    public ElevatorSetpoint(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	this.setPoint = setPoint;
    	
    	
    	//TODO remove this and exit when finished
    	
    }

    double initPos;
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.startPositionMode(-50, 0, 0);
    	initPos = Robot.elevator.getPosistion();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setPosition(setPoint + initPos);
    	
    	
    	Robot.elevator.log();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
