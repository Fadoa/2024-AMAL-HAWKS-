package frc.robot;



import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
public class Constants {
    public class SwervemodCon{

        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        
        public static final double DriveM_GearRatio = 1 / 5.8462;
        public static final double DriveA_GearRatio = 1 / 18.0;
        public static final double encoderM_R_to_M = DriveM_GearRatio * Math.PI * kWheelDiameterMeters;
        public static final double encoderA_Rot_to_Rad = DriveA_GearRatio * 2 * Math.PI;
        public static final double encoderM_RPM_perS = encoderM_R_to_M / 60;
    
        public static final double encoderA_RPM_to_Rad_perS = encoderA_Rot_to_Rad / 60;

        public static final double DriveTick_toFt = 1/42 * 6 * Math.PI/12;
        public static final double DriveTick_toCm = (DriveTick_toFt / 3.28083989501 )*100 ;
        public static final double DriveTick_toM = (DriveTick_toFt / 3.28083989501 ) ;
        public static final double kPTurn = 0.5;
    }


    public class   DriveCon{
        public static final int LFDport = 8;
        public static final int LBDport = 2;
        public static final int RFDport = 6;
        public static final int RBDport = 4;

        public static final int LFAport = 7;
        public static final int LBAport = 1;
        public static final int RFAport = 5;
        public static final int RBAport = 3;
//encoderXXXReverse
        public static final boolean encoderLFA_Reversed = true;
        public static final boolean encoderLBA_Reversed = true;
        public static final boolean encoderRFA_Reversed = true;
        public static final boolean encoderRBA_Reversed = true;

        public static final boolean encoderLFM_reversed = true;
        public static final boolean encoderLBM_reversed = true;
        public static final boolean encoderRFM_reversed = false;
        public static final boolean encoderRBM_reversed = false;

        public static final int Abs_encoder_LFDport = 1;
        public static final int Abs_encoder_LBDport = 2;
        public static final int Abs_encoder_RFDport = 3;
        public static final int Abs_encoder_RBDport = 4;

        public static final boolean Abs_encoder_LFAport_R = false;
        public static final boolean Abs_encoder_LBAport_R = false;
        public static final boolean Abs_encoder_RFAport_R = false;
        public static final boolean Abs_encoder_RBAport_R = false;

        public static final double Abs_encoder_LFD_offset = -0.254;
        public static final double Abs_encoder_LBD_offset = -1.252;
        public static final double Abs_encoder_RFD_offset = -1.816;
        public static final double Abs_encoder_RBD_offset = -4.811;

        public static final double Max_Accel_perS = 3;
        
        public static final double MaxASpeed_Radian_per_S = 2 * 2 * Math.PI;
        public static final double MaxSpeed_Meters_per_S = 5;

        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = MaxASpeed_Radian_per_S / 4;

        public static final double width = 61;
        public static final double length = 61;

        public static final SwerveDriveKinematics drive_kinematics= new SwerveDriveKinematics(
        new Translation2d(length / 2, -width/2),
        new Translation2d(length / 2, width/2),
        new Translation2d(-length/2, -width/2),
        new Translation2d(-length/2, width/2) 
        
        
        );
    }

    public class IOWheel{
    public static final double kP = 2;
    public static final double SetPoint = 14;
    public static final int CPR = 20;
    public static final int outputSpd = 25;
    public static final int İnputID = 9;
    public static final int OutputID = 9999;

    public static final int L_armID = 10;
    public static final int R_armID = 11;

    public static final int shooter_1ID = 12;
    public static final int shooter_2ID = 13;
    public static final int Aencoder = 5;

    public static final double Arm_Pos_Floor = 0.584;  // intaking
    public static final double Arm_Pos_Fender = 0.53;  // close shot
    public static final double Arm_Pos_Beginning = 0.376;  // start config
    public static final double Arm_Pos_Amp   = 0.325;  // amp scoring
    public static final double max_powah = 0.5;
    }

    public class JoystickCon {
        public static final double minimum = 0.05;
        public static final int port = 0;
        public static final int Yaxis = 1;
        public static final int XAxis = 0;
        public static final int RotAxis = 4;
        public static final int buttonID = 1;
    }
}

