package com.skilldistillery.foodtrucks;

public class FoodTruck {
	private String truckName;
	private String foodType;
	private double rating;
	private int truckID;
	private static int nextTruckID = 1;

	public FoodTruck() {

	}

	public FoodTruck(String truckName, String foodType, double rating, int truckID) {
		super();
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		this.truckID = truckID;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID, int nextTruckID) {
		truckID = truckID + nextTruckID;
		this.truckID = truckID;
	}

	public static int getNextTruckID() {
		return nextTruckID;
	}

	public static void setNextTruckID(int nextTruckID) {
		FoodTruck.nextTruckID = nextTruckID;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food Truck Name: ").append(truckName).append(", Food Type: ").append(foodType)
				.append(", Rating: ").append(rating).append(", and truckID: ").append(truckID).append(".");
		return builder.toString();
	}

}
