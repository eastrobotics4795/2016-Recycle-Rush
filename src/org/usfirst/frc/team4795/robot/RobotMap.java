package org.usfirst.frc.team4795.robot;

/**
 * Maps identification numbers to readable names.
 * This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public enum RobotMap {
  LEFT_MOTOR       (1),
  RIGHT_MOTOR      (3),
  TRANSVERSE_MOTOR (2),
  WINCH_MOTOR      (4),
  ARM_MOTOR        (5),
  RANGE_FINDER     (0);
  
  public final int value;
  
  RobotMap(int value) {
    this.value = value;
  }
  
}
