/**
 * File Name: FitnessTrackerTest.java
 * Author: Simon Tan, 041161622
 * Course: CST8284 - Object Oriented Programming
 * Section: 331
 * Assignment: Assignment 1
 * Date: February 18th, 2025
 * Professor: Sandra Iroakazi
 * Class list: FitnessTracker, FitnessTrackerTest, FitnessTrackerTest2
 * This program models a fitness tracking application. The fitness tracker records 
 * the user's full name, gender, daily steps taken, daily calories burned, and daily active minutes.
 * The program will print the user's fitness information after the user inputs their information.
 * This assignment has been completed for demo by: Simon Tan. 
 */
package tracker;

import java.util.Scanner;

/**
 * This class serves as the driver class for this program. Only contains method main.
 * 
 * @author Simon Tan
 * @version 1.0, 02/18/2025
 * @see tracker
 * @since JDK 21.0.4
 */
public class FitnessTrackerTest {

	/**
	 * Method that starts the program. This method will receive input via a Scanner object and
	 * instantiate a FitnessTracker object. The user's fitness data is printed using using a single
	 * method of the FitnessTracker object.
	 * 
	 * @param args The command line arguments. Command line arguments are not used in this program.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String firstName;
		String lastName;
		String gender;
		int stepsTaken;
		int caloriesBurned;
		int activeMinutes;
		int maintenanceCalories;
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		System.out.print("Enter gender (male/female): ");
		gender = input.nextLine();
		System.out.print("Enter daily steps: ");
		stepsTaken = input.nextInt();
		System.out.print("Enter daily calories burned: ");
		caloriesBurned = input.nextInt();
		System.out.print("Enter daily active minutes: ");
		activeMinutes = input.nextInt();
		System.out.print("Enter daily maintenance calories: ");
		maintenanceCalories = input.nextInt();
		System.out.println();
		FitnessTracker tracker = new FitnessTracker(firstName, lastName, gender, 
													stepsTaken, caloriesBurned, activeMinutes);
		tracker.displayFitnessData(maintenanceCalories);

		input.close();
	}

}
