package com.bsf;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class leetcode279 {
    public static void exec(){
        int result = numSquares2(13);
        System.out.println("result: "+result);
    }

    public static int numSquares(int n) {
        Queue<Integer> rank = new ArrayDeque<>();
        for(int i = 0; i*i<=n;i++){
            rank.add(i*i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Set<Integer> next_queue = new HashSet<Integer>();
            for(int remain:queue){
                for(int sqrt:rank){
                    if(remain == sqrt){
                        return count;
                    }
                    if(remain<sqrt){
                        break;
                    }
                    next_queue.add(remain-sqrt);
                }
            }
            queue = next_queue;
        }
        return count;
    }

    public static int numSquares2(int n){
        int[] dp = new int[n+1];
        for(int i =1 ; i<=n; i++){
            dp[i] = i;
            for(int j = 1; i-j*j >=0 ; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }
}
