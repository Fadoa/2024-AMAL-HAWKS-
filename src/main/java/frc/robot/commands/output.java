package frc.robot.commands;
import frc.robot.Constants.IOWheel;
import frc.robot.subsystem.OutputSub;
import edu.wpi.first.wpilibj2.command.Command;

public class output extends Command {
  private final OutputSub outputSub;
    private  boolean ending;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public output(OutputSub subsystem) {
    outputSub = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("fırlatma başladi!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    outputSub.setMotors(IOWheel.outputSpd);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    outputSub.setMotors(0);
    System.out.println("fırlatma bitti!!");
    ending = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ending = true){
        return true;
    }else{
        return false;
    }}}