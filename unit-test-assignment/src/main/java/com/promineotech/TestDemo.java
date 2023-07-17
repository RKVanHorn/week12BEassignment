package com.promineotech;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

	public int addPositive(int a, int b) {
		int sum;
		if (a > 0 && b > 0) {
			sum = a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return sum;
	}

//Method that takes in 2 integers and multiplies them as long as they are 0 or greater. It throws an illegal argument exception if the numbers are not both 0 or greater.

	public int multiplyPositive(int a, int b) {
		int product;
		if (a >= 0 && b >= 0) {
			product = a * b;
		} else {
			throw new IllegalArgumentException("Both parameters must be zero or greater");
		}
		return product;
	}
	
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number*number;
	}

	@VisibleForTesting
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}