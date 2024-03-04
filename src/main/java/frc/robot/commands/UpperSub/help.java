package frc.robot.commands.UpperSub;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.UpperSub;

public class help extends Command{
    UpperSub subsystem;
    public help (UpperSub subsystem){
this.subsystem = subsystem;
addRequirements(subsystem);
    }
    // set the motors to the proper volts
void setMotorVolts(double v) {
  // implement however u want
}

// read the encoder position
// tune the parameters 
PIDController pid = new PIDController(1, 0, 0);

// make sure this method runs periodically 
// set position to the desired setpoint
void moveArmToPosition(double setpoint) {

  double encoderPosition = subsystem.getPosition();
  SmartDashboard.putNumber("encoder", encoderPosition);

  double volts = pid.calculate(setpoint, encoderPosition);
  SmartDashboard.putNumber("volts", volts);

  ;
}
}
