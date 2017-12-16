package org.usfirst.frc.team1197.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class Talons {
	
	private Talon Ballpickup;
	private Talon shootingmotors;
	private Talon BLshoot;
	private Talon BRshoot;
	private Talon armmech;
	private Joystick stick;
		
	public Talons(Talon BLshoot, Talon shootingmotors, Talon armmech, Talon Ballpickup, Talon BRshoot, Joystick stick) {
		this.shootingmotors = shootingmotors;
		this.BLshoot = BLshoot;
		this.BRshoot = BRshoot;
		this.Ballpickup = Ballpickup;
		this.armmech = armmech;
		this.stick = stick;
		
	}
		
	public void PlayerControl() {
		//Shooting Motors
	
		//Ball Pickup Motor
		if(stick.getRawButton(2)) {
			Ballpickup.set(1.0);	
		}
		else {
			Ballpickup.set(0.0);
		}
		
		
		double r_y = stick.getRawAxis(5);
		
		if(Math.abs(r_y) <= 0.2) {
			r_y = 0;
		}
		
		armmech.set(r_y);
		
		double r_x = stick.getRawAxis(4);
		
		if(Math.abs(r_x) <= 0.2) {
			r_x = 0;
		}
		
		shootingmotors.set(r_x);
		BLshoot.set(r_x);
		BRshoot.set(r_x);
		
	}
	
}
