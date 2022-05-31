package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static com.ctre.phoenix.motorcontrol.InvertType.*;
import static frc.robot.Constants.*;
import static frc.robot.Constants.Drivetrain.*;

public class Drivetrain extends SubsystemBase{
    private WPI_TalonFX leftLeader = new WPI_TalonFX(LEFT_LEADER);
    private WPI_TalonFX leftFollower = new WPI_TalonFX(LEFT_FOLLOWER);
    private WPI_TalonFX rightLeader = new WPI_TalonFX(RIGHT_LEADER);
    private WPI_TalonFX rightFollower = new WPI_TalonFX(RIGHT_FOLLOWER);

    private WPI_TalonFX[] motors = {leftLeader, leftFollower, rightLeader, rightFollower};

    private DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);

    private DriveType driveType = DriveType.Arcade;

    public Drivetrain() {

        configureMotors();

//        rightLeader.setInverted(true);
//        leftLeader.setInverted(true);

        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        leftFollower.setInverted(FollowMaster);
        rightFollower.setInverted(FollowMaster);
    }

    private void configureMotors() {
        for(WPI_TalonFX motor : motors) {
            motor.configFactoryDefault();
            motor.configSupplyCurrentLimit(CURRENT_LIMIT);
        }
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }
    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    public DriveType getDriveType() {return driveType;}
    public void setDriveType(DriveType driveType) {this.driveType = driveType;}

    public static enum DriveType {
        Tank, Arcade
    }
}
