package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {
    private DcMotor lift_1;
    private DcMotor lift_2;

    public Lift(HardwareMap hardwareMap) {
        lift_1 = hardwareMap.dcMotor.get("lift_1");
        lift_2 = hardwareMap.dcMotor.get("lift_2");

        lift_1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift_2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void moveUp(){
        lift_1.setPower(1.0);
        lift_2.setPower(1.0);
    }

    public void moveDown(){
        lift_1.setPower(-1.0);
        lift_2.setPower(-1.0);
    }

    public void stop(){
        lift_1.setPower(0);
        lift_2.setPower(0);
    }

}
