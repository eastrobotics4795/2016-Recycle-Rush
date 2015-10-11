package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Use PID to hold the elevator at the current position
 */
public class HoldElevator extends Command {

	
	double holdPosition;
	
    public HoldElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.startSpeedMode(-0.5, -0.05, 0);
    	//holdPosition = Robot.elevator.getPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.elevator.setSpeed(0.001);
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
    	end();
    }
}
