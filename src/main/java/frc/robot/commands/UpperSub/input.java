package frc.robot.commands.UpperSub;
import frc.robot.subsystem.UpperSub;
import edu.wpi.first.wpilibj2.command.Command;

public class input extends Command {
  private final UpperSub subsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public input(UpperSub subsystem) {
    this.subsystem = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("input başladi!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  subsystem.intake(1);
  subsystem.shoot(0.5);

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  subsystem.intake(0);
  subsystem.shoot(0);
    System.out.println("input bitti!!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
    }
  }

