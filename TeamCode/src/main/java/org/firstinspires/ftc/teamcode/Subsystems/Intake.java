package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    private DcMotor drum_intake;

    public Intake(HardwareMap hardwareMap){
        drum_intake = hardwareMap.dcMotor.get("drum_intake");

        drum_intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drum_intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void forward(){
        drum_intake.setPower(1.0);
    }

    public void backward(){
        drum_intake.setPower(-1.0);
    }

    public void stop(){
        drum_intake.setPower(0);
    }

}
