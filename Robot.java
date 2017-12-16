package org.usfirst.frc.team1197.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends SampleRobot {
	Joystick stick = new Joystick(0);
	Talon LeftDrive;
	Talon RightDrive;
	Talon shooting_talon;
	Talon ball_talon;
	Talon arm_talon;
	Talon br_shoot_talon;
	Talon bl_shoot_talon;
	RobotDrive Drive;
	Drive mydrive;
	Talons talons;
	
	public Robot() {
		//myRobot.setExpiration(0.1);
		stick.getAxisType(1);
		LeftDrive = new Talon(0);
		RightDrive = new Talon(1);
		arm_talon = new Talon(2);
		shooting_talon = new Talon(3);
		ball_talon = new Talon(4);
		br_shoot_talon = new Talon(6);
		bl_shoot_talon = new Talon(5);
		talons = new Talons(bl_shoot_talon, shooting_talon, arm_talon, ball_talon, br_shoot_talon, stick);
		Drive = new RobotDrive(LeftDrive, RightDrive);
	}

	@Override
	public void robotInit() {
	}
	
	@Override
	public void autonomous() {
	}

	@Override
	public void operatorControl() {
		while(isOperatorControl() && isEnabled()) {
			talons.PlayerControl();
			mydrive.PlayerControl();
		}
	}
	
	@Override
	public void test() {
	}
}
