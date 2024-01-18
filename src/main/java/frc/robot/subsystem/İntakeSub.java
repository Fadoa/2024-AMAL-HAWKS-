package frc.robot.subsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.SparkRelativeEncoder.Type;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants;
public class İntakeSub extends SubsystemBase{

    private final CANSparkMax IOMotor;
    private final RelativeEncoder encoderM;
    static double sensorPosition;
    

public İntakeSub(int Motor_ID, boolean IOmotorR){
    IOMotor = new CANSparkMax(Motor_ID, MotorType.kBrushed);
    encoderM = IOMotor.getEncoder(Type.kQuadrature,Constants.IOWheel.CPR);
    IOMotor.setInverted(IOmotorR);
    resetEncoder();
}
public void resetEncoder(){
    encoderM.setPosition(0);
}
public void setMotors(int outputSpeed){
    IOMotor.set(outputSpeed);
}

}
