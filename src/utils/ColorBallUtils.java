package utils;

import java.math.BigInteger;

public class ColorBallUtils {

	public static void main(String[] args) {
		// 幂次
		BigInteger pow = pow(7, 3);
		System.out.println("幂次: " + pow);
		// 组合
		BigInteger findCombination = findCombination(7, 3);
		System.out.println("组合: " + findCombination);
	}

	// 求幂次
	public static BigInteger pow(int x, int y) {
		BigInteger xx = new BigInteger(x + "");
		BigInteger result = new BigInteger("1");

		for (int i = 0; i < y; i++) {
			result = result.multiply(xx);
		}

		return result;
	}

	// 求组合
	public static BigInteger findCombination(int bottom, int top) {
		BigInteger start = new BigInteger(bottom + "");
		BigInteger a = new BigInteger("1");
		for (int i = 0; i < top; i++) {
			a = a.multiply(start);
			start = start.subtract(new BigInteger("1"));
		}
		BigInteger startTop = new BigInteger(top + "");
		BigInteger c = new BigInteger("1");
		for (int i = top; i > 1; i--) {
			c = c.multiply(new BigInteger(i + ""));
		}
		return a.divide(c);
	}

}
