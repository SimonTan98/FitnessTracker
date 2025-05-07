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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class serves to test the calculateDistance, fitnessLevel,
 * and calculateCalorieDefecit methods of the FitnessTracker class.
 * <p>
 * This class assumes the user is a male named John Smith. In a single 
 * day, John has taken 2000 steps, burned 1000 calories, and was active
 * for 10 minutes. It also assumes that the user entered a maintenance
 * calorie level of 2000.
 * <p>
 * To simulate a failed test for testCalculateDistance, the calculateDistance 
 * method was modified to divide male step length by daily steps taken, rather 
 * than multiply.
 * <p>
 * To simulate a failed test for testFitnessLevel, the fitnessLevel
 * method was modified to not consider users with exactly 1000 calories 
 * burned to be moderately active if they also do not have 75 - 150 
 * weekly active minutes (caloriesBurned > 1000 instead of 
 * caloriesBurned >= 1000).
 * <p>
 * To simulate a failed test for testCalculateCalorieDefecit, the 
 * calculateCalorieDefecit method's logic was changed from
 * calorieDifference = maintenanceCalories - caloriesBurned to
 * calorieDifference = caloriesBurned - maintenanceCalories.
 * 
 * @author Simon Tan
 * @version 1.0, 02/18/2025
 * @see tracker
 * @since JDK 21.0.4
 */
public class FitnessTrackerTest2 {

	/**
	 * A private FitnessTracker object used for this test class.
	 */
	private FitnessTracker tracker;
	
	/**
	 * {@value #EPSILON} A double representing the accepted margin of error.
	 */
	private final static double EPSILON = 1E-12;
	
	/**
	 * An int that represents the user specified maintenance calorie level.
	 * Assumes the user entered 2000.
	 */
	private int maintenanceCalories = 2000;
	
	/**
	 * Method that runs before each test is performed and sets up the test
	 * environment. Will instantiate the FitnessTracker object with sample 
	 * user information. Assumes the user is a male named John Smith. 
	 * In a single day, John has taken 2000 steps, burned 1000 calories, 
	 * and was active for 10 minutes.
	 */
	@Before
	public void setUp() {
		String firstName = "John";
		String lastName = "Smith";
		String gender = "male";
		int stepsTaken = 2000;
		int caloriesBurned = 1000;
		int activeMinutes = 10;
		tracker = new FitnessTracker(firstName, lastName, gender, 
									 stepsTaken, caloriesBurned, activeMinutes);
	}

	/**
	 * Method that runs after each test is performed and cleans the test
	 * environment. Sets the tracker variable to null.
	 */
	@After
	public void tearDown() {
		tracker = null;
	}

	/**
	 * Method that tests the calculateDistance method. The expected
	 * distance walked based on the sample data is 1600.0 meters. The
	 * actual distance is calculated using the calculateDistance method.
	 * The test will pass if the expected distance is equal to the actual
	 * distance, within EPSILON.
	 */
	@Test
	public void testCalculateDistance() {
		double expectedDistance = 1600.0;
		double actualDistance = tracker.calculateDistance();
		assertEquals(expectedDistance, actualDistance, EPSILON);
	}

	/**
	 * Method that tests the fitnessLevel method. The expected fitness
	 * level of the sample user is "Moderately Active" (The user has 
	 * only 70 weekly active minutes, but has burned 1000 calories).
	 * The fitness level is determined using the fitnessLevel method.
	 * A wrong fitness level is set to another possible option, "Unknown".
	 * The test will pass if the actual fitness level is not equal to
	 * the wrong fitness level.
	 */
	@Test
	public void testFitnessLevel() {
		String wrongActivityLevel = "Unknown";
		String actualActivityLevel = tracker.fitnessLevel();
		assertNotEquals(wrongActivityLevel, actualActivityLevel);
	}

	/**
	 * Method that tests the calculateCalorieDefecit method. The user must
	 * burn more calories to reach maintenance, which would be represented
	 * by a positive number returned by the calculateCalorieDefecit method. 
	 * The calorie defecit is calculated using the calculateCalorieDefecit
	 * method. The test will pass if the calorie defecit is greater than
	 * zero.
	 */
	@Test
	public void testCalculateCalorieDefecit() {
		double calorieDefecit = tracker.calculateCalorieDefecit(maintenanceCalories);
		boolean defecitIsPositive = calorieDefecit > 0;
		assertTrue("Calorie defecit is less than or equal to 0", defecitIsPositive);
	}

}
