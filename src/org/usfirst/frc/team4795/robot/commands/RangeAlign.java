package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Attempt to use PID control to drive up to a tote
 */
public class RangeAlign extends PIDCommand {

	double target;
	
    public RangeAlign(double distance) {
    	super(-0.02, 0, 0);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	target = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	
    	
    	
    	Robot.drivetrain.log();
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return target - Robot.drivetrain.getRange();
	}

	@Override
	protected void usePIDOutput(double output) {
		
		
		if(Math.abs(output) > 0.3){
			Robot.drivetrain.drive(Math.signum(output) * 0.3, Math.signum(output) * 0.3);
			
			SmartDashboard.putNumber("speed", Math.signum(output) * 0.3);
		}
		else{
			Robot.drivetrain.drive(output, output);
			SmartDashboard.putNumber("speed", output);
		}
		
    	
		
    	
	}
}
