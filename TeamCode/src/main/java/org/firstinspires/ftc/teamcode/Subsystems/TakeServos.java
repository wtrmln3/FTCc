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
        take_2.setDirection(CRServo.Direction.FORWARD);

        stop();
    }

    public void setPower(double power){
        power = Math.max(-1.0, Math.min(1.0, power));
        take_1.setPower(power);
        take_2.setPower(power);

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
