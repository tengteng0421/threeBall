package test;

import java.math.BigInteger;

import ball.BallCount;

public class Test {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {

			BallCount b = new BallCount(i);
			BigInteger calc = b.calc();
			// System.out.println(calc);
			b.printResult();
		}
	}
}
