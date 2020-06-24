package test;

import java.math.BigInteger;

import ball.BallCount;

public class Test {
	public static void main(String[] args) {
		BallCount b = new BallCount(5);
		BigInteger calc = b.calc();
		System.out.println(calc);
		b.printResult();
	}
}
