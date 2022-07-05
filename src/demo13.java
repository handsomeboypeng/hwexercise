/*
■ 题目描述

        【最长连续子序列】

        有N个正整数组成的一个序列。给定整数sum，求长度最长的连续子序列，使他们的和等于sum，返回此子序列的长度，

        如果没有满足要求的序列，返回-1。

        输入描述

        序列

        1,2,3,4,2

        sum

        6

        输出描述

        序列长度

        3

        输入描述

        序列

        1,2,3,4,2

        sum：6

        输出描述

        序列长度：3

        示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        1,2,3,4,2

        6

        输出

        3

        说明

        解释

        1,2,3和4,2两个序列均能满足要求，所以最长的连续序列为1,2,3，因此结果为3。*/

import java.util.*;
import java.io.*;

public class demo13{
    public static void main(String[] rds)throws IOException{
        Scanner br = new Scanner(System.in);
        String str = br.nextLine();
        int sum = br.nextInt();
        String[] list = str.split(",");
        int max = -1;
        for(int i =0;i<list.length;i++){
            int temp = sum;
            for(int j = i;j<list.length;j++){
                temp -= Integer.parseInt(list[j]);
                if(temp == 0){
                    max = max>j-i?max:j-i;
                }
            }
        }
        max = max >-1?max+1:-1;
        System.out.println(max);
    }
}

/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int[] arr = new int[split.length];
        int sum = Integer.parseInt(sc.nextLine());
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
            total += arr[i];
        }
        if (total < sum) {
            System.out.println(-1);
        } else if (total == sum) {
            System.out.println(split.length);
        } else {
            int left = 0;
            int right = 0;
            int temp = 0;
            while (left < arr.length && right < arr.length) {
                if (temp < sum) {
                    temp += arr[right];
                    right++;
                } else if (temp != sum) {
                    temp -= arr[left];
                    left++;
                }
                if (temp == sum) {
                    System.out.println(right - left);
                    left++;
                    right = left;
                    temp = 0;
                }
            }
        }
    }
}*/
