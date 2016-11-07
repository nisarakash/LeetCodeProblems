/*
 * 123. Best Time to Buy and Sell Stock III
 */

public class BuySellStock3 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(prices[i] - min, left[i - 1]);
		}

		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(max - prices[i], right[i + 1]);
		}

		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(left[i] + right[i], maxProfit);
		}

		return maxProfit;
	}
}
