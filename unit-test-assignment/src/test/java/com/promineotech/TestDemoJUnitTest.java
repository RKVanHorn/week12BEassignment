package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(()-> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(5, 10, 15, false),
				arguments(0, 1, 1, true),
				arguments(-1, 5, 4, true)
				);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(10, 15)).isEqualTo(25);
		assertThat(testDemo.addPositive(1000, 50)).isEqualTo(1050);
	}
	
	/*Parameterized Test that checks if testDemo.multiplyPositive properly multiplies two numbers together and throws an exception if necessary.
	 * The stream of arguments sends in the parameters for the test with the first two arguments being the numbers to multiply together, the third
	 * being the correct answer and the fourth being a boolean that tells us if the Illegal Argument Exception is expected to be thrown(true) or not(false)*/
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyPositive")
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(()-> testDemo.multiplyPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForMultiplyPositive(){
		return Stream.of(
				arguments(2, 5, 10, false),
				arguments(1, 100, 100, false),
				arguments(0, 5, 0, false),
				arguments(-1, 4, -4, true)
				);
	}
	
	/*Test that checks to see if testDemo.multiplyPositive correctly multiplies the two numbers in parentheses and gets back the number in the .isEqualTo parentheses */
	
	@Test
	void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly() {
		assertThat(testDemo.multiplyPositive(0, 5)).isEqualTo(0);
		assertThat(testDemo.multiplyPositive(10, 5)).isEqualTo(50);
		assertThat(testDemo.multiplyPositive(2, 6)).isEqualTo(12);
		assertThat(testDemo.multiplyPositive(11, 7)).isEqualTo(77);
	}

	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		//Given: the method randomNumberSquared in testDemo
		TestDemo mockDemo=spy(testDemo);
		//When: the random number is 5
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		//Then: randomNumberSquared should return 25
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	
}
