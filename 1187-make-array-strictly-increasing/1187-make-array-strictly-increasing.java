// class Solution {
//     public int makeArrayIncreasing(int[] arr1, int[] arr2) {
//         int n = arr1.length;
//         int m = arr2.length;
//         int[] dp = new int[n + 1];
//         for (int i = 1; i <= n; i++) {
//             dp[i] = Integer.MAX_VALUE;
//             for (int j = 0; j < m; j++) {
//                 if (arr2[j] <= arr1[i - 1]) {
//                     continue;
//                 }
//                 dp[i] = Math.min(dp[i], dp[i - 1] + 1);
//             }
//         }

//         int minOperations = dp[n];
//         if (minOperations == Integer.MAX_VALUE) {
//             return -1;
//         }
//         return minOperations;
//     }
// }
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int[][] dp = new int[m][m + 1];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.sort(arr2);
        dp[0][0] = arr1[0];
        dp[0][1] = arr2[0] < arr1[0] ? arr2[0] : Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            dp[i][0] = arr1[i] > dp[i - 1][0] ? arr1[i] : Integer.MAX_VALUE;
            for (int j = 1; j <= i + 1; j++) {
                int a = arr1[i] > dp[i - 1][j] ? arr1[i] : Integer.MAX_VALUE;
                int ind = Arrays.binarySearch(arr2, dp[i - 1][j - 1] + 1);
                ind = ind >= 0 ? ind : Math.abs(ind) - 1;

                int b = dp[i - 1][j - 1] < Integer.MAX_VALUE && ind >= 0 && ind < arr2.length ? arr2[ind] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(a, b);
            }
        }

        // for (int[] d : dp) System.out.println(Arrays.toString(d));

        int res = -1;
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[m - 1][i] < Integer.MAX_VALUE) {
                res = i;
                break;
            }
        }

        return res;
    }
}