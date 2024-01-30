package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.commands.*;
import frc.robot.subsystem.SwearveSub;
import frc.robot.subsystem.UpperSub;
import frc.robot.Constants.JoystickCon;
import frc.robot.commands.SwerveJoystick;
import frc.robot.commands.input;
import frc.robot.commands.output;

public class RobotContainer {
//L_armID,int R_armID ,int shooter_1ID, int shooter_2ID, int ImotorID
  private final SwearveSub swervesub = new SwearveSub();

  private final UpperSub upperSub = new UpperSub(10,11,12,13,9);
  private final input input = new input(upperSub);
  private final output output = new output(upperSub);
  private final expel expel = new expel(upperSub);
  private final intakepos intakepos = new intakepos(upperSub);
  private final CommandXboxController xboyJoy = new CommandXboxController(JoystickCon.port); 
      private final Supplier<Boolean> fieldBased = () -> true;
  private final GenericHID dpadHid = new GenericHID(JoystickCon.port); 
  public RobotContainer() {
  

    swervesub.setDefaultCommand(new SwerveJoystick(
      swervesub,
       ()-> -xboyJoy.getLeftY(),
        ()-> xboyJoy.getLeftX(),
         ()-> xboyJoy.getRightX(),fieldBased));

    configureBindings();
  }

  private void configureBindings() {
xboyJoy.a().onTrue(expel);
xboyJoy.b().onTrue(input);
xboyJoy.y().onTrue(intakepos);
xboyJoy.x().onTrue(output);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
