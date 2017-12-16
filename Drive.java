package org.usfirst.frc.team1197.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class Drive {

	private Joystick stick;
	private Talon LeftDrive;
	private Talon RightDrive;
	
	public Drive(Talon LeftDrive, Talon RightDrive, Joystick stick) {
		this.LeftDrive = LeftDrive;
		this.RightDrive = RightDrive;
	}
	
public void PlayerControl() {
	double left_y = stick.getRawAxis(1);
	double left_x = stick.getRawAxis(0);
	double lorv = 1; //left or right 
	double DangerFactor = 0.5;//controls the max speed
	double ControlVariable = 0; //don't screw with this
	
	if(Math.abs(left_y) <= 0.2) {
		left_y = 0;
	}	

	if(Math.abs(left_x) <= 0.2) {
		left_x = 0;
	
	left_x *= lorv * left_x * left_x * 2;
		
	}
	if (left_y == 0 && Math.abs(left_x) > 0) {
		left_y = Math.abs(left_x);
		if (left_x > 0) {
			left_x += 1;
		}
		if (left_x < 0) {
			left_x -= 1;
		}
	}
	double left_m;
	double right_m;
	
	left_m = (1 + left_x) * left_y; //controls motor turning inputs
	right_m = (1 - left_x) * left_y;
		
	if (left_m < -1) {
		ControlVariable = left_m - 1;
		left_m -= ControlVariable;
		right_m -= ControlVariable;
	}
	if (right_m < -1) {
		ControlVariable = right_m - 1;
		left_m -= ControlVariable;
		right_m -= ControlVariable;
	}
	
	if (left_m < -1) {
		left_m = -1;
	}
	if (right_m < -1) {
		right_m = -1;
	}
	
	LeftDrive.set(left_m * DangerFactor);
	RightDrive.set(right_m * DangerFactor);
  }
}
