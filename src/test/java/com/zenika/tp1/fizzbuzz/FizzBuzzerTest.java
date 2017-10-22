package com.zenika.tp1.fizzbuzz;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

//import com.zenika.tp1.fizzbuzz.FizzBuzzer;

/**
 * Unit test for {@link FizzBuzzer}
 */
public class FizzBuzzerTest {

	/**
	 * FizzBuzzer under test
	 */
	//private final FizzBuzzer fizzBuzzer = new FizzBuzzer();

	/** */
	@Test
	public void multipleOfThree() {
		//assertThat(fizzBuzzer.getFizzBuzz(3), equalTo("fizz"));
		//assertThat(fizzBuzzer.getFizzBuzz(6), equalTo("fizz"));
		//assertThat(fizzBuzzer.getFizzBuzz(3 * 1567), equalTo("fizz"));
	}

	/** */
	@Test
	public void multipleOfFive() {
		//assertThat(fizzBuzzer.getFizzBuzz(5), equalTo("buzz"));
		//assertThat(fizzBuzzer.getFizzBuzz(10), equalTo("buzz"));
		//assertThat(fizzBuzzer.getFizzBuzz(5 * 1567), equalTo("buzz"));
	}

	/** */
	@Test
	public void multipleOfThreeAndFive() {
		//assertThat(fizzBuzzer.getFizzBuzz(0), equalTo("fizzbuzz"));
		//assertThat(fizzBuzzer.getFizzBuzz(15), equalTo("fizzbuzz"));
		//assertThat(fizzBuzzer.getFizzBuzz(15 * 34), equalTo("fizzbuzz"));
	}

	/** */
	@Test
	public void multipleOfNeitherThreeNorFive() {
		//assertThat(fizzBuzzer.getFizzBuzz(1), equalTo(""));
		//assertThat(fizzBuzzer.getFizzBuzz(2), equalTo(""));
	}
}
