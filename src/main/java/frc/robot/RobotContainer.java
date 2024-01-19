package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystem.OutputSub;
import frc.robot.subsystem.SwearveSub;
import frc.robot.subsystem.İntakeSub;

import frc.robot.Constants.JoystickCon;
import frc.robot.commands.SwerveJoystick;
import frc.robot.commands.input;
import frc.robot.commands.output;
import frc.robot.commands.expel;
public class RobotContainer {

  private final SwearveSub swervesub = new SwearveSub();

  private final İntakeSub intakesub = new İntakeSub(Constants.IOWheel.İnputID, false);
  private final input input = new input(intakesub);
  public final expel expel = new expel(intakesub);
  private final OutputSub outputSub = new OutputSub(Constants.IOWheel.OutputID, false);
  private final output output = new output(outputSub);
  private final XboxController xboyJoy = new XboxController(JoystickCon.port); 
  public RobotContainer() {
  

    swervesub.setDefaultCommand(new SwerveJoystick(
      swervesub,
       ()-> -xboyJoy.getLeftY() ,
        ()-> xboyJoy.getLeftX(),
         ()-> xboyJoy.getRightX(),
          ()-> !xboyJoy.getAButton()));

    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(xboyJoy,1).onTrue(input);
    new JoystickButton(xboyJoy, 2).onTrue(output);

    new JoystickButton(xboyJoy, 3).onTrue(expel);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
