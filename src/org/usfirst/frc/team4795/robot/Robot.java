package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.HomeArm;
import org.usfirst.frc.team4795.robot.subsystems.Arm;
import org.usfirst.frc.team4795.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4795.robot.subsystems.Elevator;
import org.usfirst.frc.team4795.robot.subsystems.TransverseWheel;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Top level class for command-based robot code.
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the IterativeRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the manifest file in the
 * resource directory.
 */
public class Robot extends IterativeRobot {

  public static OperatorInterface operatorInterface;

  // IMPORTANT init the subsystems in robotInit!
  public static DriveTrain drivetrain;
  public static Elevator elevator;
  public static Arm arm;
  public static TransverseWheel transverseWheel;

  private CameraServer cameraServer;
  
  /**
   * Initializes the robot subsystems.
   */
  @Override
  public void robotInit() {
    // set initial values for the PID (error correction) system
    SmartDashboard.putNumber("P", 0.001);
    SmartDashboard.putNumber("I", 0);
    SmartDashboard.putNumber("D", 0);

    drivetrain = new DriveTrain();
    elevator = new Elevator();
    arm = new Arm();
    transverseWheel = new TransverseWheel();

    operatorInterface = new OperatorInterface();
    
    try {
      cameraServer = CameraServer.getInstance();
      cameraServer.setQuality(10);
      cameraServer.startAutomaticCapture();
    } catch (Exception e) {
      e.printStackTrace();
    }

    new HomeArm().start();
  }
  
  /**
   * Initializes the robot when entering disabled mode.
   */
  @Override
  public void disabledInit() {}
  
  /**
   * Executes periodically while the robot is disabled.
   */
  @Override
  public void disabledPeriodic() {
    // handle currently executing commands
    Scheduler.getInstance().run();
  }
  
  /**
   * Initializes the robot when entering autonomous mode.
   */
  @Override
  public void autonomousInit() {}

  /**
   * Executes periodically while the robot is autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // handle currently executing commands.
    Scheduler.getInstance().run();
  }
  
  /**
   * Initializes the robot when entering remote control mode.
   */
  @Override
  public void teleopInit() {}

  /**
   * Executes periodically while the robot is under remote control.
   */
  @Override
  public void teleopPeriodic() {
    // handle currently executing commands.
    Scheduler.getInstance().run();
  }
  
  /**
   * Initializes the robot when entering test mode.
   */
  @Override
  public void testInit() {}

  /**
   * Executes periodically while the robot is under test.
   */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
  
}
