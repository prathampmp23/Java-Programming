package SlidingWindow;

public class MaxPointCanObtain {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        int rightIdx = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum += cardPoints[rightIdx];
            rightIdx--;

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int cardPoints[] = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;

        System.out.println(maxScore(cardPoints, k));
    }
}
