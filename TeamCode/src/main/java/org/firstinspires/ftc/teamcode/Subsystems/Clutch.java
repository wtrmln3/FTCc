package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Clutch {
    private Servo clutch_1;
    private Servo clutch_2;

    private final double CLOSED = 0.0;
    private final double OPEN = 1.0;

    public Clutch(HardwareMap hardwareMap){
        clutch_1 = hardwareMap.get(Servo.class, "clutch_1");
        clutch_2 = hardwareMap.get(Servo.class, "clutch_2");

        clutch_1.setDirection(Servo.Direction.REVERSE);
        clutch_2.setDirection(Servo.Direction.FORWARD);

        close();
    }

    public void open(){
        clutch_1.setPosition(1.0);
        clutch_2.setPosition(1.0);
    }

    public void close(){
        clutch_1.setPosition(0.0);
        clutch_2.setPosition(0.0);
    }

}
