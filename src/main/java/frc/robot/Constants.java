package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public final class Constants {
    public static final SupplyCurrentLimitConfiguration CURRENT_LIMIT = new SupplyCurrentLimitConfiguration(true, 20, 20, 0.1); //enable these limits, current limit, trigger threshold, trigger threshold time

    public static final class Drivetrain {
        public static final int LEFT_LEADER =    0;
        public static final int LEFT_FOLLOWER =  1;
        public static final int RIGHT_LEADER =   2;
        public static final int RIGHT_FOLLOWER = 3;
    }

    public static final class Arm {
        public static final int ARM_SOLENOID_FORWARD =    0;
        public static final int ARM_SOLENOID_REVERSE =    1;
        public static final int DUMPER_SOLENOID_FORWARD = 2;
        public static final int DUMPER_SOLENOID_REVERSE = 3;
    }

    public static final class Controller {
        public static final int ARM_ACTUATION = 0;
        public static final int DUMPER_ACTUATION = 1;
    }
}
