import java.util.Scanner;

import javax.swing.JOptionPane;

import kareltherobot.*;

public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method


	// You will add very many variables!!
	int bigPile = 0;
	int pilnum = 0; //how many piles
	int totbeep = 0; // total beeper amount

	Robot roomba = new Robot(11, 6, Directions.South, 0); 

	public static void main(String[] args) {

		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();
		d.getInfo();
		d.cleanRoom();
		d.displayResults();
	}

	/**
	 * This method gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */
	private void getInfo() {

		String wrldName = "basicRoom.wld";

		World.readWorld(wrldName);
		World.setVisible(true);
		World.setDelay(2);


	}

	/** This method will have all the logic that takes the Robot to every location 
	 * and cleans up all piles of beepers.  Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */
	private void cleanRoom() {
		//clears all piles 
		while (roomba.frontIsClear()){
			while (roomba.frontIsClear()){
				
				while (roomba.facingSouth()){
					if (roomba.frontIsClear()){
						while (roomba.nextToABeeper()){
							roomba.pickBeeper();
						}
						roomba.move();
						
					}
					else{
						roomba.turnLeft();
						roomba.move();
						roomba.turnLeft();
					}
					
				}
				while (roomba.facingNorth()){
					if (roomba.frontIsClear()){
						while (roomba.nextToABeeper()){
							roomba.pickBeeper();
						}
						roomba.move();
						
					}
					else{
						turnRight();
						roomba.move();
						turnRight();
					}
					
				}
			}
			
		}
	}
		/* while true
			while (roomba.frontIsClear()==true){
				if (roomba.nextToABeeper()){
					pilnum++;
					roomba.pickBeeper();
					totbeep++;
				}
				else{
					roomba.move();
				}
			
			while (roomba.frontIsClear()==false){
				
				if (roomba.facingSouth()==true){
					roomba.turnLeft();
					if (roomba.nextToABeeper()){
						pilnum++;
					}
					while (roomba.nextToABeeper()){

						roomba.pickBeeper();
						totbeep++;
					}
					roomba.move();
					if (roomba.nextToABeeper()){
						pilnum++;
					}
					while (roomba.nextToABeeper()){
						roomba.pickBeeper();
						totbeep++;
					}
					roomba.turnLeft();
					

				}
				else{
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
					/*if (roomba.frontIsClear()== false){
						break;
					

					if (roomba.nextToABeeper()){
						pilnum++;
					}
					while (roomba.nextToABeeper()){
						roomba.pickBeeper();
						totbeep++;
					}
					
					roomba.move();
					if (roomba.nextToABeeper()){
						pilnum++;
					}
					while (roomba.nextToABeeper()){
						roomba.pickBeeper();
					}
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
					

				}
			} 
	}/*
	
	
		//
		// the line below causes a null pointer exception
		// what is that and why are we getting it?

		// obviously, lots more here
	
	p
	/** This method displays the results of cleaning the room.  All of the info
	 * in the pdf that describes the problem need to be displayed.  You can present
	 * this info in the console (boring) or you can present using JOptionPane (cool!)
	 */
	private void displayResults() {
		//int max = cleanRoom();
		System.out.println("Pile Number: "+ pilnum);
	}
	private void turnRight(){
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
	}

}
