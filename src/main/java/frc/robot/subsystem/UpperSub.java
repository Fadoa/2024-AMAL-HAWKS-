package frc.robot.subsystem;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.IOWheel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class UpperSub extends SubsystemBase {
    
    private RelativeEncoder Aencoder;
    private CANSparkMax  L_arm;
    private CANSparkMax  R_arm;

    private CANSparkMax  shooter_1;
    private CANSparkMax  shooter_2;


    private CANSparkMax  Imotor;
    
    public static UpperSub getInstance(){
        UpperSub instance = new UpperSub(IOWheel.L_armID, IOWheel.R_armID, IOWheel.shooter_1ID, IOWheel.shooter_2ID, IOWheel.İnputID);
        return instance;
    }
    
    public UpperSub(int L_armID,int R_armID ,int shooter_1ID, int shooter_2ID, int ImotorID){

        L_arm = new CANSparkMax(L_armID, MotorType.kBrushed);
        R_arm = new CANSparkMax(R_armID, MotorType.kBrushed);
    
        Aencoder = L_arm.getEncoder();
        shooter_1 = new CANSparkMax(shooter_1ID, MotorType.kBrushless);
        shooter_2 = new CANSparkMax(shooter_2ID, MotorType.kBrushless);
    
        Imotor = new CANSparkMax(ImotorID, MotorType.kBrushed);
    }
    public void Arm_Pos_Beginning(double pos){
        double kp = -15.0;
        double error = pos - Aencoder.getPosition();
        double power= kp * error;
        move_arm(power);
    }
    public void move_arm(double power){
        if(power > IOWheel.max_powah){
            power = IOWheel.max_powah;
        }else if(power<-IOWheel.max_powah){
            power = -IOWheel.max_powah;
        }
        L_arm.set(-power);
        R_arm.set(-power);
    }
    public void intake(double power){
        Imotor.set(power);
    }

    public void shoot (double power){
        shooter_1.set(-power);
        shooter_2.set(-power);//check polarities
    }

}
