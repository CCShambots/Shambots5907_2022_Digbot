package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.Constants.Controller;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final Arm arm = new Arm();

  private final Joystick controller = new Joystick(0);

  public RobotContainer() {

    drivetrain.setDefaultCommand(new DriveCommand(drivetrain, () -> controller.getRawAxis(0), () -> controller.getRawAxis(1), () -> controller.getRawAxis(5)));

    configureButtonBindings();
  }

  private void configureButtonBindings() {

    new JoystickButton(controller, Constants.Controller.ARM_ACTUATION)
            .whenPressed(new InstantCommand(() -> arm.actuateArm()));

    new JoystickButton(controller, Controller.DUMPER_ACTUATION)
            .whenPressed(new InstantCommand(() -> arm.actuateDumper()));

    new JoystickButton(controller, XboxController.Button.kLeftBumper.value)
      .whenPressed(new InstantCommand(() -> drivetrain.toggleDriveType()));
  }
}
