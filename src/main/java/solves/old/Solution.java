package solves.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

 
    public static int calculate(int[] coins, int sum) {
    	
    	int[][] wayswithncoins = new int[coins.length][sum+1];

    	// 1st colunmn
    	for(int i=0;i<coins.length;i++) {
    		wayswithncoins[i][0]=1;
    	}
    	// 1st row
    	int firstCoin = coins[0];
    	for(int i=firstCoin;i<=sum;i++) {
    		if(i%firstCoin==0) {
        		wayswithncoins[0][i]=1;
    		}
    	}
    	
    	for(int i=1;i<coins.length;i++) {
    		int currentCoin = coins[i];
    		for(int j=1;j<=sum;j++) {
    			int countsWithCurrentCoin = 0;
    			int balance=j;
    			while(balance>=0) {
    				countsWithCurrentCoin+=wayswithncoins[i-1][balance];
    				balance-=currentCoin;
    			}
    			wayswithncoins[i][j]=countsWithCurrentCoin;
    		}
    	}

    	for(int[] cc:wayswithncoins) {
    		for(int c:cc) {
    			System.out.print(c + " ");
    		}
    		System.out.println();
    	}

    	return wayswithncoins[coins.length-1][sum];
    }

    public static void main(String[] args) {
        System.out.println(calculate(new int[] {1,2,3},4));
    }
}