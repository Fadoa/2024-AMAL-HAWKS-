package frc.robot.subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.CANSparkLowLevel.MotorType;
public class OutputSub extends SubsystemBase{

    private final CANSparkMax IOMotor;
    private final RelativeEncoder encoderM;
    static double sensorPosition;
    

public OutputSub(int Motor_ID, boolean IOmotorR){
    IOMotor = new CANSparkMax(Motor_ID, MotorType.kBrushed);
    encoderM = IOMotor.getEncoder();
    IOMotor.setInverted(IOmotorR);
    resetEncoder();
}
public void resetEncoder(){
    encoderM.setPosition(0);
}
public void setMotors(int outputSpeed){
    IOMotor.set(2*outputSpeed);
}

}

