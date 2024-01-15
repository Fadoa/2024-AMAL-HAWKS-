package frc.robot.subsystem;


import frc.robot.Constants;
import frc.robot.Constants.SwervemodCon;
import frc.robot.Constants.DriveCon;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwearveMod {
private final CANSparkMax driveM;
private final CANSparkMax driveA;

private final RelativeEncoder encoderM;
private final RelativeEncoder encoderA;

private final PIDController pidController;

private final AnalogInput Abs_encoder;
private final boolean Abs_encoderR;
private final double Abs_encoder_off;

public SwearveMod(int driveM_ID,int driveA_ID, boolean driveM_R, boolean driveA_R, int Abs_encoder_ID, double Abs_encoder_off, boolean Abs_encoderR){

    this.Abs_encoder_off = Abs_encoder_off;
    this.Abs_encoderR = Abs_encoderR;
    Abs_encoder = new AnalogInput(Abs_encoder_ID);

    driveM = new CANSparkMax(driveM_ID,MotorType.kBrushless);
    driveA = new CANSparkMax(driveA_ID, MotorType.kBrushless);

    driveM.setInverted(driveM_R);
    driveA.setInverted(driveA_R);

    encoderM = driveM.getEncoder();
    encoderA = driveA.getEncoder();

    encoderM.setPositionConversionFactor(Constants.SwervemodCon.encoderM_R_to_M);
    encoderM.setVelocityConversionFactor(Constants.SwervemodCon.encoderM_RPM_perS);
    encoderA.setPositionConversionFactor(Constants.SwervemodCon.encoderA_Rot_to_Rad);
    encoderA.setVelocityConversionFactor(Constants.SwervemodCon.encoderA_RPM_to_Rad_perS);

    pidController = new PIDController(SwervemodCon.kPTurn, 0,0);
    Reset_encoder();
}

public double DriveM_pos(){
    return encoderM.getPosition();
}

public double DriveA_pos(){
    return encoderA.getPosition();
}

public double DriveM_V(){
    return encoderM.getVelocity();
}

public double DriveA_V(){
    return encoderA.getVelocity();
}

public double Abs_encoder_RAD(){
    double angle = Abs_encoder.getVoltage()/ RobotController.getVoltage5V();
    angle *= 2.0 * Math.PI ;
    angle -= Abs_encoder_off;
    return angle * (Abs_encoderR ? -1.0 : 1.0);
}

public void Reset_encoder(){
encoderM.setPosition(0);
encoderA.setPosition(Abs_encoder_RAD());
}

public SwerveModuleState giveState(){
    return new SwerveModuleState(DriveM_V(), new Rotation2d(DriveA_pos()));
}

public void setState(SwerveModuleState state){
if (Math.abs(state.speedMetersPerSecond) < 0.001){
    stop();
    return;
}
state = SwerveModuleState.optimize(state, giveState().angle);
driveM.set(state.speedMetersPerSecond / DriveCon.MaxSpeed_Meters_per_S);
driveA.set(pidController.calculate(DriveA_pos(), state.angle.getRadians()));
SmartDashboard.putString("Swerve no. " + Abs_encoder.getChannel() + " state", state.toString());
}

public void stop(){
    driveM.set(0);
    driveA.set(0);
}
}
