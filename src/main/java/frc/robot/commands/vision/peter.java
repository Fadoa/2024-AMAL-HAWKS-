package frc.robot.commands.vision;

import java.io.File;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.general_Funct.*;
import frc.robot.subsystem.swervedrive.SwerveSubsystem;
public class peter extends Command{
    private SwerveSubsystem  subsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                         "swerve/neo"));

    public peter(SwerveSubsystem subsystem){
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }


    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("havari peter باللس ");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
System.out.println("یورولدم");    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
