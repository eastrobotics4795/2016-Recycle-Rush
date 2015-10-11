package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.can.CANMessageNotAllowedException;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator up at fixed rate
 */
public class ElevatorUp extends Command {

    public ElevatorUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.startPercentMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try{
    		Robot.elevator.setSpeed(-0.5);
    	}
    	catch(CANMessageNotAllowedException e){
    		
    	}
    	
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
