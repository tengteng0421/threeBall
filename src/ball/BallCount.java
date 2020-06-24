package ball;

import java.math.BigDecimal;
import java.math.BigInteger;

import utils.ColorBallUtils;

public class BallCount {
	// 取样次数
	private int n;
	// 所有可能
	private BigInteger allCount;
	// 正确的可能
	private BigInteger rightCount;
	private BigInteger lastOne;

	// 构造方法, 传入抽取次数
	public BallCount(int n) {
		this.n = n;
		this.allCount = ColorBallUtils.pow(4, n);
	}

	// 计算概率
	public BigInteger calc() {
		// 其他球的个数为i
		// // 其中一个球的个数
		// int a = 0;
		// 符合条件的情况总数
		BigInteger greenIsMax = new BigInteger("0");
		for (int m = 0; m < n; m++) {
			boolean isRight = checkIsMMin(m, n);
			if (isRight) {
				// 退出
				break;
			}
			int y = 2 * n - (n - m) - 2 * m;
			if (m > 0) {
				y++;
			}
			// Cmn
			BigInteger firstComb = ColorBallUtils.findCombination(n, m);
			// 2^y
			BigInteger pow = ColorBallUtils.pow(2, y);
			// Cmm相加
			BigInteger sum = getCombSum(m, m);
			BigInteger multiply = firstComb.multiply(pow).multiply(sum);
			greenIsMax = greenIsMax.add(multiply);
			this.lastOne = firstComb.multiply(pow);
			// System.out.print("绿: " + (n - m) + ", " + (multiply));
			// System.out.println("\t" + "C" + m + "," + n + "*" + 2 + "^" + y +
			// "*sum " + sum);
		}
		this.rightCount = greenIsMax;
		return greenIsMax;
	}

	// 获取组合相加结果
	private BigInteger getCombSum(int m, int ac) {
		BigInteger result = new BigInteger("0");
		int count = 0;
		StringBuffer sb = new StringBuffer("m=" + m + ", sum(");
		for (int a = 0; a <= ac; a++) {
			// 去除不符合的a
			if (a - 2 * m + this.n <= 0 || a + m - this.n > 0 || 2 * a - m > 0) {
				continue;
			}
			BigInteger findCombination = ColorBallUtils.findCombination(m, a);
			if (a > 0 && m / a == 2 && m % a == 0) {
				findCombination = findCombination.divide(new BigInteger("2"));
			}
			result = result.add(findCombination);
			count++;
			sb.append("C" + a + "," + m + "+");
		}
		// if (count == 1 && 2 * m - n >= 0) {
		// return new BigInteger("1");
		// }
		sb.replace(sb.length() - 1, sb.length(), ")");
		// System.out.println(sb.toString());
		return result;
	}

	// 检测m是否过大
	private boolean checkIsMMin(int m, int n) {
		if (3 * m - 2 * n >= 0) {
			return true;
		}
		return false;
	}

	// 输出正确结果
	public void printResult() {
		System.out.print("取样次数: " + n + "\t");
		// System.out.println("比例: " + rightCount + "/" + allCount + "\t");
		System.out.print("结果: "
				+ new BigDecimal(rightCount).divide(new BigDecimal(allCount)).setScale(4, BigDecimal.ROUND_HALF_UP));
		System.out.println();
		System.out.println();
	}
}
