package com.skilldistillery.foodtrucks;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		FoodTruckApp foodTruckApp = new FoodTruckApp();

		foodTruckApp.launch(keyboard, foodTruckApp);

		keyboard.close();
	}

	private void launch(Scanner kb, FoodTruckApp foodTruckApp) {
		boolean run = true;
		
		System.out.println("Welcome to the FoodTruckApp!");
		FoodTruck[] trucks = foodTruckApp.inputTruck(kb);

		while (run) {
			foodTruckApp.printMenu();
			run = foodTruckApp.chooseItemFromMenu(kb, trucks);
		}
	}

	private FoodTruck[] inputTruck(Scanner kb) {
		System.out.println("How many food trucks do you want to enter?");
		int arrIndex = kb.nextInt();
		FoodTruck[] ftArr = new FoodTruck[arrIndex];
		kb.nextLine();

		String foodType = "";
		double rating = 0;

		for (int i = 0; i < ftArr.length; i++) {
			System.out.println("Enter a food truck's name or \"quit\": ");
			String truckName = kb.nextLine();
			
			if (truckName.equalsIgnoreCase("quit")) {
				FoodTruck[] earlyBreakFTArr = Arrays.copyOf(ftArr, i); // creates a copy of ftArr
				return earlyBreakFTArr; // cancels loop by returning the copied array
			} else {
				System.out.println("Enter type of food: ");
				foodType = kb.nextLine();

				do {
					System.out.println("Enter rating (0-5): ");
					rating = kb.nextDouble();
					if (rating > 5 || rating < 0) {
						System.out.println("The rating was out of range. Please try again.");
					}
				} while (rating > 5 || rating < 0);
				kb.nextLine();

				ftArr[i] = new FoodTruck();
				ftArr[i].setTruckName(truckName);
				ftArr[i].setTruckName(truckName);
				ftArr[i].setFoodType(foodType);
				ftArr[i].setRating(rating);
				ftArr[i].setTruckID(i + 100); // truckID assigned by the index + 100
			}
		}

		return ftArr;
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

	private boolean chooseItemFromMenu(Scanner kb, FoodTruck[] trucks) {
		int selection = 0;

		do {
			System.out.println("Enter your selection (1-4): ");
			selection = kb.nextInt();

			if (selection > 4 || selection < 1) {
				System.out.println("Your selection was out of range. Please try again.");
			}
		} while (selection > 4 || selection < 1); // repeats asking until the user's selection is in range

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
		double sum = 0;

		for (int i = 0; i < trucks.length; i++) {
			sum += trucks[i].getRating();
		}

		double average = sum / trucks.length * 1.0;
		average = (Math.round((average) * 10.0)) / 10.0;  // rounds average to nearest tenth
		
		System.out.println("Average Food Truck Rating: " + average);
	}

	private void showHighestRated(FoodTruck[] trucks) {
		double highest = trucks[0].getRating();
		int highestIndex = 0;

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i].getRating() > highest) {
				highestIndex = i;
			}
		}

		String highestProperties = trucks[highestIndex].toString();

		System.out.println("Highest Rated " + highestProperties);
	}
}
