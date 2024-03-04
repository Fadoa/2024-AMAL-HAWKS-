package frc.robot.subsystem;


import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.IOWheel;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class UpperSub extends SubsystemBase {
    
    private Encoder Aencoder;
    private VictorSPX  L_arm;
    private VictorSPX  R_arm;

    private CANSparkMax  shooter_1;
    private CANSparkMax  shooter_2;

    private CANSparkMax climber1;
    private CANSparkMax climber2;

    private CANSparkMax  Imotor;
    


    public static double ArmRatio = 360/7 * 2 / 60;
    public static UpperSub getInstance(){
        UpperSub instance = new UpperSub(IOWheel.L_armID, IOWheel.R_armID, IOWheel.shooter_1ID, IOWheel.shooter_2ID, IOWheel.İnputID);
        return instance;
    }
    
    public  UpperSub(int L_armID,int R_armID ,int shooter_1ID, int shooter_2ID, int ImotorID){

        L_arm = new VictorSPX(-1);
        R_arm = new VictorSPX(-1);
    

        Aencoder = new Encoder(5,6, true, EncodingType.k4X);
        shooter_1 = new CANSparkMax(shooter_1ID, MotorType.kBrushless);
        shooter_2 = new CANSparkMax(shooter_2ID, MotorType.kBrushless);
    
        climber1 = new CANSparkMax(13, MotorType.kBrushed );

        climber2= new CANSparkMax(14, MotorType.kBrushed );

        Imotor = new CANSparkMax(ImotorID, MotorType.kBrushed);

    
    }
    public void Arm_Pos_Beginning(double pos){
        double kp = -15.0;
        double error = pos - Aencoder.get();
        double power= kp * error;
        move_arm(power);
    }
    public void move_arm(double power){
        L_arm.set(ControlMode.PercentOutput,-power);
        R_arm.set(ControlMode.PercentOutput,power);
    }
    public void intake(double power){
        Imotor.set(power);
    }

    public void shoot (double power){
        shooter_1.set(-power);
        shooter_2.set(-power);//check polarities
    }

    public void climber(double power){
        climber1.set(power);
        climber2.set(power);
    }
    public int getPosition(){
        return Aencoder.get();
    }
    public double getPositionMeter(){
    return 23;
    }



    @Override
    public void periodic() {
        SmartDashboard.putNumber(   "encoderTick", getPosition());
    }
}
