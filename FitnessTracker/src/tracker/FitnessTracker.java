/**
 * File Name: FitnessTracker.java
 * Author: Simon Tan, 041161622
 * Course: CST8284 - Object Oriented Programming
 * Section: 331
 * Assignment: Assignment 1
 * Date: February 18th, 2025
 * Professor: Sandra Iroakazi
 * Class list: FitnessTracker, FitnessTrackerTest, FitnessTrackerTest2
 * This program models a fitness tracking application. The fitness tracker records 
 * the user's full name, gender, daily steps taken, daily calories burned, and daily active minutes.
 * The fitness tracker also contains methods to calculate distance walked in meters, calculate
 * weekly average minutes, determine the user's fitness level, calculate the user's daily calorie
 * defecit/surplus, and display all the user's data.
 * This assignment has been completed for demo by: Simon Tan. 
 */
package tracker;

/**
 * This class models a fitness tracker device. The fitness tracker records 
 * the user's full name, gender, daily steps taken, daily calories burned, and daily active minutes.
 * The fitness tracker also contains methods to calculate distance walked in meters, calculate
 * weekly average minutes, determine the user's fitness level, calculate the user's daily calorie
 * defecit/surplus, and display all the user's data.
 * 
 * @author Simon Tan
 * @version 1.0, 02/18/2025
 * @see tracker
 * @since JDK 21.0.4
 */
public class FitnessTracker {
	
	/**
	 * a String that records the user's first name.
	 */
	private String firstName;
	
	/**
	 * a String that records the user's last name.
	 */
	private String lastName;
	
	/**
	 * a String that records the user's gender.
	 */
	private String gender;
	
	/**
	 * an int that records the user's daily steps taken.
	 */
	private int stepsTaken;
	
	/**
	 * an int that records the user's daily calories burned.
	 */
	private int caloriesBurned;
	
	/**
	 * an int that records the user's daily active minutes.
	 */
	private int activeMinutes;

	/**
	 * The constructor sets the user's first name, last name, gender, daily steps taken,
	 * daily calories burned, and daily active minutes.
	 *
	 * @param firstName A String representing the user's first name.
	 * @param lastName A String representing the user's last name.
	 * @param gender A String representing the user's gender.
	 * @param stepsTaken An int representing the user's daily steps taken.
	 * @param caloriesBurned An int representing the user's daily calories burned.
	 * @param activeMinutes An int representing the user's daily active minutes.
	 */
	public FitnessTracker(String firstName,String lastName, String gender, 
							int stepsTaken, int caloriesBurned, int activeMinutes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.stepsTaken = stepsTaken;
		this.caloriesBurned = caloriesBurned;
		this.activeMinutes = activeMinutes;
	}

    /**
     * Returns the user's first name.
     * @return the user's first name.
     */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the user's first name.
	 * @param firstName The user's first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the user's last name.
	 * @return the user's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's last name.
	 * @param lastName The user's last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the user's gender.
	 * @return the user's gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the user's gender.
	 * @param gender The user's gender.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the user's daily steps taken.
	 * @return the user's daily steps taken.
	 */
	public int getStepsTaken() {
		return stepsTaken;
	}

	/**
	 * Sets the user's daily steps taken.
	 * @param stepsTaken The user's daily steps taken.
	 */
	public void setStepsTaken(int stepsTaken) {
		this.stepsTaken = stepsTaken;
	}

	/**
	 * Returns the user's daily calories burned.
	 * @return the user's daily calories burned.
	 */
	public int getCaloriesBurned() {
		return caloriesBurned;
	}

	/**
	 * Sets the user's daily calories burned.
	 * @param caloriesBurned The user's daily calories burned.
	 */
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	/**
	 * Returns the user's daily active minutes.
	 * @return the user's daily active minutes.
	 */
	public int getActiveMinutes() {
		return activeMinutes;
	}

	/**
	 * Sets the user's daily active minutes.
	 * @param activeMinutes The user's daily active minutes.
	 */
	public void setActiveMinutes(int activeMinutes) {
		this.activeMinutes = activeMinutes;
	}
	
	/**
	 * Method that calculates the user's distance walked in meters.
	 * The method multiplies the user's daily steps taken with one of two predetermined
	 * values representing the length of a single step. The user's gender will determine
	 * which value is used to calculate distance walked.
	 * 
	 * @return a double representing the distance the user has walked in meters.
	 */
	public double calculateDistance() {
		final double MALE_STEP_LENGTH = 0.8;
		final double FEMALE_STEP_LENGTH = 0.7;
		double distance;
		if (gender.equalsIgnoreCase("male")) {
			distance = MALE_STEP_LENGTH * stepsTaken;
		}
		else {
			distance = FEMALE_STEP_LENGTH * stepsTaken;
		}
		return distance;
	}
	
	/**
	 * Method that calculates the user's average weekly active minutes based on the user's
	 * daily active minutes. 
	 * 
	 * @return a double representing the user's average weekly active minutes.
	 */
	private double calculateWeeklyMinutes() {
		double weeklyMinutes = activeMinutes * 7.0;
		return weeklyMinutes;
	}

	/**
	 * Method that determines the user's activity level based on average weekly active minutes and
	 * daily calories burned. Weekly active minutes is calculated by calling calculateWeeklyMinutes(). 
	 * The user is categorized into one of three fitness levels...
	 * <p>
	 * Active: More than 150 active minutes per week and over 2000 
	 * calories burned.
	 * <p>
	 * Moderately Active: Between 75-150 active minutes per week 
	 * or 1000-2000 calories burned.
	 * <p>
	 * Sedentary: Less than 75 active minutes per week and under 
	 * 1000 calories burned.
	 * <p>
	 * One flaw noted in this program's logic occurs when weekly minutes
	 * is over 150, but calories burned is less than 1000. The program
	 * would determine the person to be of unknown activity level, when 
	 * one may argue that the person should be considered moderately active. 
	 * A similar result occurs when the person has more than 2000 calories 
	 * burned, but less than 75 weekly active minutes.
	 * 
	 * @return a String stating the user's fitness level.
	 */
	public String fitnessLevel() {
		double weeklyMinutes = calculateWeeklyMinutes();
		String activityLevel = "Unknown";
		
		if(weeklyMinutes > 150 && caloriesBurned > 2000) {
			activityLevel = "Active";
		}
		else if ((weeklyMinutes >= 75 && weeklyMinutes <= 150) || 
				(caloriesBurned >= 1000 && caloriesBurned <= 2000)) {
			activityLevel = "Moderately Active";
		}
		else if (weeklyMinutes < 75 && caloriesBurned < 1000) {
			activityLevel="Sedentary";
		}
		
		return activityLevel;
	}
	
	/**
	 * Method that calculates the defecit/surplus of the user's daily calories burned against a
	 * user-specified maintenance level. A positive number represents how many more calories 
	 * need to be burned to reach maintenance level. A negative number represents the surplus 
	 * amount of calories burned after reaching maintenance level.
	 * 
	 * @param maintenanceCalories The daily maintenance calorie level as specified by the user.
	 * @return an int stating the difference between maintenance level and daily calories burned.
	 */
	public int calculateCalorieDefecit(int maintenanceCalories) {
		int calorieDifference = maintenanceCalories - caloriesBurned;
		return calorieDifference;
	}
	
    /**
     * Method that displays all the user's fitness data. Uses printf to print the user's
     * full name, gender, daily steps taken, daily calories burned, daily active minutes, 
     * distance traveled in meters, average weekly active minutes, fitness level, and 
     * calorie defecit/surplus. Calls calculateCalorieDefecit() to calculate the calorie 
     * defecit/surplus.
     * 
     * @param maintenanceCalories The daily maintenance calorie level as specified by the user.
     */
    public void displayFitnessData(int maintenanceCalories) {
        
    	System.out.printf("--- User Fitness Data ---%n"
    					  +"Name: %s %s%n"
    					  +"Gender: %s%n"
    					  +"Daily Steps: %d%n"
    					  +"Daily Calories Burned: %d%n"
    					  +"Daily Active Minutes: %d%n"
    					  +"Distance Walked: %.1f meters%n"
    					  +"Weekly Active Minutes: %.1f%n"
    					  +"Fitness Level: %s%n"
    					  +"Daily Calorie Defecit/Surplus: %d%n", 
    					  firstName, lastName, 
    					  gender, 
    					  stepsTaken, 
    					  caloriesBurned,
    					  activeMinutes,
    					  calculateDistance(), 
    					  calculateWeeklyMinutes(), 
    					  fitnessLevel(),
    					  calculateCalorieDefecit(maintenanceCalories));
        System.out.println("Fitness Level Criteria:");
        System.out.println("Active: More than 150 active minutes per week and over 2000 calories burned.");
        System.out.println("Moderately Active: 75-150 active minutes per week or 1000-2000 calories burned.");
        System.out.println("Sedentary: Less than 75 active minutes per week and under 1000 calories burned.");
    }

}