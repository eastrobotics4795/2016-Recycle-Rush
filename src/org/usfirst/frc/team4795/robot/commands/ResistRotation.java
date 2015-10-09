package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResistRotation extends PIDCommand {

    public ResistRotation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(0, 0, 0);
    
    	
    	
    	
    	
    	
    	
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	
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
		
		return Robot.drivetrain.getZRotation() - 20;
	}

	@Override
	protected void usePIDOutput(double output) {
		
		SmartDashboard.putNumber("PID in", returnPIDInput());
		
		SmartDashboard.putNumber("PID out", output);
		
		Robot.drivetrain.drive(output, -output);
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		double p = SmartDashboard.getNumber("P", 0);
    	double i = SmartDashboard.getNumber("I", 0);
    	double d = SmartDashboard.getNumber("D", 0);
    	
    	getPIDController().setPID(p, i, d);
		
	}
}
