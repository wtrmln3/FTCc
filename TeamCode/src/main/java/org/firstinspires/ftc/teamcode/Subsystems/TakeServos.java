package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class TakeServos {
    private CRServo take_1;
    private CRServo take_2;

    public TakeServos(HardwareMap hardwareMap) {
        take_1 = hardwareMap.get(CRServo.class, "take_1");
        take_2 = hardwareMap.get(CRServo.class, "take_2");

        take_1.setDirection(CRServo.Direction.REVERSE);
    }

    public void up(){
        take_1.setPower(1.0);
        take_2.setPower(1.0);

    }

    public void down(){
        take_1.setPower(-1.0);
        take_2.setPower(-1.0);
    }

    public void stop(){
        take_1.setPower(0);
        take_2.setPower(0);
    }
}
