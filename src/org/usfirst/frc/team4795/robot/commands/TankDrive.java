package org.usfirst.frc.team4795.robot.commands;


import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Simple tankdrive command
 */
public class TankDrive extends Command {

	

	
	
	
    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//inverting one wheel is handled in the subsystem
    	
    	double throttle = 1 - ((Robot.oi.getLeftJoy().getThrottle() + 1) / 2.0);
    	SmartDashboard.putNumber("multiplier", throttle);
    	
    	Robot.drivetrain.drive(Robot.oi.getLeftJoy().getY() * throttle, Robot.oi.getRightJoy().getY() * throttle);
    	
    	Robot.drivetrain.log();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //run forever until interrupt
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0); //stop the motor
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
