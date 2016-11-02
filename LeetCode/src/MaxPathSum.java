/*
 * 124. Binary Tree Maximum Path Sum
 */

public class MaxPathSum {
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathSum1(root);
		return maxSum;
	}

	public int maxPathSum1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSum1(root.left);
		int rightSum = maxPathSum1(root.right);

		// System.out.println("Root: "+root.val+"\tLeftSum: "+leftSum+"\tRightSum: "+rightSum);

		int temp = root.val + leftSum + rightSum;
		if (maxSum < temp) {
			maxSum = temp;
		}
		if (root.val <= 0) {
			if (leftSum <= 0 && rightSum <= 0) {
				return 0;
			} else {
				int i = leftSum > rightSum ? root.val + leftSum : root.val
						+ rightSum;
				return i > 0 ? i : 0;
			}

		} else {
			if (leftSum <= 0 && rightSum <= 0) {
				return root.val;
			} else {
				return leftSum > rightSum ? root.val + leftSum : root.val
						+ rightSum;
			}
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}