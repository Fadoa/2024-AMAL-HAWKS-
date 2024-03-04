package frc.robot.commands.UpperSub;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.IOWheel;
import frc.robot.commands.general_Funct.mastahpiece;
import frc.robot.subsystem.UpperSub;

public class AngleToMotor extends Command {
    
    private final UpperSub subsystem;

    private final PIDController pid = new PIDController(IOWheel.kP,IOWheel.kI,IOWheel.kD);


    public AngleToMotor(UpperSub subsystem,double angle) {
        this.subsystem  = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("angle to motor start");
    }

 
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        

        // calculations

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        System.out.println("bitttiiiii");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        
        return false;
    }


}
