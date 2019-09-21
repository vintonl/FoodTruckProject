package com.skilldistillery.foodtrucks;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		FoodTruckApp foodTruckApp = new FoodTruckApp();

		foodTruckApp.launchApp(keyboard, foodTruckApp);

		keyboard.close();
	}

	private void launchApp(Scanner keyboard, FoodTruckApp foodTruckApp) {
		System.out.println("Welcome to the FoodTruckApp!");
		FoodTruck[] trucks = foodTruckApp.inputTruck(keyboard);

		boolean runMenu = true;
		while (runMenu) {
			foodTruckApp.printMenu();
			runMenu = foodTruckApp.chooseFromMenu(keyboard, trucks);
		}
	}

	private FoodTruck[] inputTruck(Scanner keyboard) {
		System.out.println("How many food trucks do you want to enter?");
		int arrIndex = keyboard.nextInt();
		keyboard.nextLine();
		
		FoodTruck[] foodTruckArr = new FoodTruck[arrIndex];

		String foodType = "";
		double rating = 0;

		for (int i = 0; i < foodTruckArr.length; i++) {
			System.out.println("Enter a food truck's name or \"quit\" to stop entering trucks:");
			String truckName = keyboard.nextLine();
			
			if (truckName.equalsIgnoreCase("quit")) {
				FoodTruck[] earlyExitArr = Arrays.copyOf(foodTruckArr, i);
				return earlyExitArr; 
			} else {
				System.out.println("Enter type of food:");
				foodType = keyboard.nextLine();

				do {
					System.out.println("Enter rating (0-5):");
					rating = keyboard.nextDouble();
					if (rating > 5 || rating < 0) {
						System.out.println("The rating was out of range. Please try again.");
					}
				} while (rating > 5 || rating < 0);
				keyboard.nextLine();

				foodTruckArr[i] = new FoodTruck();
				foodTruckArr[i].setTruckName(truckName);
				foodTruckArr[i].setTruckName(truckName);
				foodTruckArr[i].setFoodType(foodType);
				foodTruckArr[i].setRating(rating);
				foodTruckArr[i].setTruckID(i + 1); 
			}
		}

		return foodTruckArr;
	}

	private void printMenu() {
		System.out.println();
		System.out.println("|*****************************************|");
		System.out.println("| * Please choose one of the following: * |");
		System.out.println("|1. List all existing food trucks.        |");
		System.out.println("|2. See the average rating of food trucks.|");
		System.out.println("|3. Display the highest-rated food truck. |");
		System.out.println("|4. Quit the program.                     |");
		System.out.println("|*****************************************|");
	}

	private boolean chooseFromMenu(Scanner keyboard, FoodTruck[] trucks) {
		int selection = 0;

		do {
			System.out.println("Enter your selection (1-4): ");
			selection = keyboard.nextInt();

			if (selection > 4 || selection < 1) {
				System.out.println("Your selection was out of range. Please try again.");
			}
		} while (selection > 4 || selection < 1);

		System.out.println();

		switch (selection) {
		case 1:
			displayTrucks(trucks);
			break;
		case 2:
			seeAverageRating(trucks);
			break;
		case 3:
			showHighestRated(trucks);
			break;
		case 4:
			System.out.println("Thank you, and have a great one!");
			return false;
		}

		return true;
	}

	private void displayTrucks(FoodTruck[] trucks) {
		for (int i = 0; i < trucks.length; i++) {
			System.out.println(trucks[i].toString());
		}
	}

	private void seeAverageRating(FoodTruck[] trucks) {
		double sumRatings = 0;

		for (int i = 0; i < trucks.length; i++) {
			sumRatings += trucks[i].getRating();
		}

		double average = sumRatings / trucks.length * 1.0;
		double averageRounded = (Math.round((average) * 100.0)) / 100.0;
		
		System.out.println("Average Food Truck Rating: " + averageRounded);
	}

	private void showHighestRated(FoodTruck[] trucks) {
		double highestRating = trucks[0].getRating();

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i].getRating() > highestRating) {
				highestRating = trucks[i].getRating(); 
			}
		}

		for (int i = 0; i < trucks.length; i++) { // look for the match and any ties
			if (highestRating == trucks[i].getRating()) { 
				System.out.println("Highest Rated " + trucks[i].toString());	
			}
		}
	}
}
