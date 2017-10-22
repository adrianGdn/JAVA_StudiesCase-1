package com.zenika.tp1.fibonacci;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;

import org.junit.Test;

//import com.zenika.tp1.fibonacci.FibonacciComputer;
//import com.zenika.tp1.fizzbuzz.FizzBuzzer;

/**
 * Unit test for {@link FizzBuzzer}
 */
public class FibonacciComputerTest {

	/**
	 * FibonacciComputer under test
	 */
	//private final FibonacciComputer fibonacciComputer = new FibonacciComputer();

	/**  */
	@Test
	public void miscValue() {
		assertThat(("0"), equalTo("0"));
	}

	/**  */
	@Test
	public void zeroValue() {
		//assertThat(fibonacciComputer.getFibonacci(0), equalTo(BigInteger.ZERO));
	}

	/**  */
	@Test
	public void oneValue() {
		//assertThat(fibonacciComputer.getFibonacci(1), equalTo(BigInteger.ONE));
	}

	/**  */
	@Test
	public void veryHigh() {
		//final BigInteger expected = new BigInteger("2662710205480735617346452022100755074809023407208374441801919604845563638678145849451440");
		//assertThat(fibonacciComputer.getFibonacci(420), equalTo(expected));
	}

	/**  */
	@Test
	public void negativeValue() {
		//fibonacciComputer.getFibonacci(-2);
	}
}
