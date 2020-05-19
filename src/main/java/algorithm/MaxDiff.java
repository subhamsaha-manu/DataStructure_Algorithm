package java.algorithm;

import java.util.Scanner;

public class MaxDiff {

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int diff = 0;
        int smallest = input[0];
        for (int i = 0; i < n; i++) {

            if(input[i] < smallest)
                smallest = input[i];
            if(input[i] - smallest < diff)
                diff = input[i] - smallest;
        }
    }
}
