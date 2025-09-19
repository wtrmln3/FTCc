package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Panama", group = "TeleOp")
public class Panama extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    private DcMotor lift_1;
    private DcMotor lift_2;
    private DcMotor drum_intake;
    private CRServo take_1;
    private CRServo take_2;
    private Servo clutch_1;
    private Servo clutch_2;

    @Override
    public void runOpMode() {
        initHardware();

        waitForStart();

        while (opModeIsActive()) {
            driveRobot();
            controlLiftSystem();
            controlDrumIntake();
            controlTakeServos();
            controlClutches();

            telemetry.update();
        }
    }

    private void initHardware(){
        leftFront = hardwareMap.dcMotor.get("leftFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        lift_1 = hardwareMap.dcMotor.get("lift_1");
        lift_2 = hardwareMap.dcMotor.get("lift_2");
        drum_intake = hardwareMap.dcMotor.get("drum_intake");
        take_1 = hardwareMap.get(CRServo.class, "take_1");
        take_2 = hardwareMap.get(CRServo.class, "take_2");
        clutch_1 = hardwareMap.get(Servo.class, "clutch_1");
        clutch_2 = hardwareMap.get(Servo.class, "clutch_2");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        take_1.setDirection(CRServo.Direction.REVERSE);
        clutch_1.setDirection(Servo.Direction.REVERSE);
        lift_1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift_2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void driveRobot(){
        double drive = -gamepad1.left_stick_y;   // forward/back
        double turn = gamepad1.right_stick_x;    // left/right

        double leftPower = drive + turn;
        double rightPower = drive - turn;

        leftFront.setPower(leftPower);
        leftBack.setPower(leftPower);
        rightFront.setPower(rightPower);
        rightBack.setPower(rightPower);
    }

    private void controlLiftSystem(){
        if (gamepad1.left_trigger > 0.1) {
            lift_1.setPower(1.0);
            lift_2.setPower(1.0);
        } else if (gamepad1.right_trigger > 0.1) {
            lift_1.setPower(-1.0);
            lift_2.setPower(-1.0);
        } else {
            lift_1.setPower(0);
            lift_2.setPower(0);
        }
    }

    private void controlDrumIntake(){
        if (gamepad1.a) {
            drum_intake.setPower(1.0);
        } else if (gamepad1.b) {
            drum_intake.setPower(-1.0);
        } else {
            drum_intake.setPower(0);
        }
    }

    private void controlTakeServos(){
        if (gamepad1.dpad_up) {
            take_1.setPower(1.0);
            take_2.setPower(1.0);
        } else if (gamepad1.dpad_down) {
            take_1.setPower(-1.0);
            take_2.setPower(-1.0);
        } else {
            take_1.setPower(0);
            take_2.setPower(0);
        }
    }

    private void controlClutches(){
        if (gamepad1.x) {
            clutch_1.setPosition(0.0);
            clutch_2.setPosition(0.0);
        } else if (gamepad1.y) {
            clutch_1.setPosition(1.0);
            clutch_2.setPosition(1.0);
        }
    }
}
