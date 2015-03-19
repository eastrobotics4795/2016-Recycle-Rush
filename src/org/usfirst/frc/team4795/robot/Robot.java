
package org.usfirst.frc.team4795.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4795.robot.commands.autonomous.GrabAndLift;
import org.usfirst.frc.team4795.robot.subsystems.Arm;
import org.usfirst.frc.team4795.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4795.robot.subsystems.Elevator;
import org.usfirst.frc.team4795.robot.subsystems.TransverseWheel;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static OI oi;
	
	//IMPORTANT init the subsystems in robotInit!
	public static DriveTrain drivetrain;
	public static Elevator elevator;
	public static Arm arm;
	public static TransverseWheel transverseWheel;
	
	private CameraServer cameraServer;
	
	Command autonomousCommand;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	SmartDashboard.putNumber("P", 0);
    	SmartDashboard.putNumber("I", 0);
    	SmartDashboard.putNumber("D", 0);
		
        //Init subsystems
		drivetrain = new DriveTrain();
		elevator = new Elevator();
		arm = new Arm();
		transverseWheel = new TransverseWheel();
		
		oi = new OI();
		
		autonomousCommand = new GrabAndLift();
		
		
		try{
			cameraServer = CameraServer.getInstance();
			cameraServer.setQuality(50);
			cameraServer.startAutomaticCapture();
		}
		catch(Exception e){
			e.printStackTrace();
		}

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
