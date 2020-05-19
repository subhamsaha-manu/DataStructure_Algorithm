package java.algorithm;

import java.util.Scanner;

public class ArrayQuestions {

    static void lengthOfLongestNonNegativeSubArray(int[] input) {

        int len = 0;
        int curr_len = 0;
        int start = 0;
        int curr_sum = 0;
        int sum = 0;
        int end = 0;
        for (int i = 0; i <= input.length; i++) {
            if (i == input.length || input[i] < 0) {
                if (curr_len == len) {
                    if (curr_sum > sum) {
                        sum = curr_sum;
                        end = i == input.length ? input.length: i - 1;
                        start = i - curr_len;
                    }
                }
                if (curr_len > len) {
                    len = curr_len;
                    sum = curr_sum;
                    end = i == input.length? input.length: i - 1;
                    start = i - curr_len;
                }
                curr_len = 0;
                curr_sum = 0;
            } else {
                curr_sum += input[i];
                curr_len++;
            }
        }
        System.out.println("Max length " + len + "\t" + start + "\t" + end);
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = sc.nextInt();
        lengthOfLongestNonNegativeSubArray(input);
    }
}
