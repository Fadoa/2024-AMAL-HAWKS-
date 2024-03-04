package frc.robot.commands.UpperSub;

import frc.robot.subsystem.UpperSub;
import edu.wpi.first.wpilibj2.command.Command;

public class intakepos extends Command {
  private final UpperSub subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public intakepos(UpperSub subsystem) {
    this.subsystem = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("intakepos başladı!!!!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subsystem.Arm_Pos_Beginning(0.545);
    subsystem.intake(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

