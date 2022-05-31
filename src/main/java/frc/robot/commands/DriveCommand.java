package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

import static frc.robot.subsystems.Drivetrain.DriveType.*;

public class DriveCommand extends CommandBase {

    private Drivetrain drivetrain;
    private DoubleSupplier leftStickX;
    private DoubleSupplier leftStickY;
    private DoubleSupplier rightStickY;

    public DriveCommand(Drivetrain drivetrain, DoubleSupplier leftStickX, DoubleSupplier leftStickY, DoubleSupplier rightStickY) {
        this.drivetrain = drivetrain;
        this.leftStickX = leftStickX;
        this.leftStickY = leftStickY;
        this.rightStickY = rightStickY;
    }

    public void execute() {
        if(drivetrain.getDriveType() == Tank) {
            drivetrain.tankDrive(-leftStickY.getAsDouble(), -rightStickY.getAsDouble());
        } else if(drivetrain.getDriveType() == Arcade) {
            drivetrain.arcadeDrive(-leftStickY.getAsDouble(), leftStickX.getAsDouble());
        }
    }
}
