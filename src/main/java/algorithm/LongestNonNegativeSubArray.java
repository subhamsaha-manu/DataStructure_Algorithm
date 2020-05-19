package java.algorithm;

import java.io.InputStreamReader;

public class LongestNonNegativeSubArray {
    public static void main(String[] args){
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] array = str.split(" ");
        int[] numbers = new int[n];
        int i=0;
        for(String a: array){
            numbers[i]=Integer.parseInt(a);
            i++;
        }

        int currentStart=0;
        int longestStart=0;
        int currSum=0;
        int longestSum=0;
        int currLength=0;
        int longestLength=0;
        for(int j=0;j<n;j++){
            currSum=0;
            currentStart=j;
            currLength=0;
            while(numbers[j]>=0){
                currSum+=numbers[j];
                currLength++;
                j++;
            }
            if(currLength==longestLength){
                if(currSum>longestSum){
                    longestStart=currentStart;
                    longestSum=currSum;
                }
            }
           else if(currLength>longestLength) {
                longestLength = currLength;
                longestStart = currentStart;
                longestSum = currSum;
            }


        }*/
    }
}
