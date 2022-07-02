package org.misc;

import java.util.HashMap;

class Solution {
    // A function that represents the answer to the problem for a given state

    ///////////////////      Solution 1      //////////////////////////
    private static int dp(int i) {
        if (i <= 2) return i; // Base cases
        return dp(i - 1) + dp(i - 2); // Recurrence relation
    }

    ///////////////////      Solution 2      //////////////////////////
    ///////////////////      Using memoization      //////////////////////////

    private static int dp2(int i){

        HashMap<Integer, Integer> memo = new HashMap<>();

        if (i<= 2) return i;
        // Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
        // store it inside a hashmap to refer to in the future

        if(!memo.containsKey(i)){
            memo.put(i, dp2(i -1) + dp2(i -2));
        }
        return memo.get(i);
    }

    public static int climbStairs(int n) {
        return dp(n);
    }
    public static int climbStairs2(int n) {
        return dp2(n);
    }

    ///////////////////      Solution 3 bottom-up Approach      //////////////////////////

    public static int climbStairs3(int n) {
        if (n == 1) return 1;;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main (String args[]){

        int result1 = climbStairs(4);
        int result2 = climbStairs2(4);
        int result3 = climbStairs3(4);

        System.out.println("result1::" + result1);
        System.out.println("result2::" + result2);
        System.out.println("result3::" + result3);

    }
}