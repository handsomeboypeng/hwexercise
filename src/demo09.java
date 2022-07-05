/*■ 题目描述
        【水仙花数】

        所谓水仙花数，是指一个n位的正整数，其各位数字的n次方和等于该数本身。

        例如153是水仙花数，153是一个3位数，并且153 = 1^3 + 5^3 + 3^3。

        输入描述

        第一行输入一个整数n，表示一个n位的正整数。n在3到7之间，包含3和7。

        第二行输入一个正整数m，表示需要返回第m个水仙花数。

        输出描述

        返回长度是n的第m个水仙花数。个数从0开始编号。

        若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积。

        若输入不合法，返回-1。

        示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        3 0

        输出

        153

        说明

        153是第一个水仙花数

        示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        9

        1

        输出

        -1

        说明

        9超出范围*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo09 {
    public static void main(String[] args) {
        calculate();
    }

    public static void calculate() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 3 && n <= 7) {
            int m = sc.nextInt();
            int temp = 1;
            for (int i = 0; i < n; i++) {
                temp *= 10;
            }
            int min = temp / 10;
            int max = temp - 1;
            Map<Integer, Integer> data = new HashMap<>();
            int count = 0;
            int lastNum = 0;
            for (int i = min; i <= max; i++) {
                if (isRightNum(i, n)) {
                    data.put(count++, i);
                    if (i > lastNum) {
                        lastNum = i;
                    }
                }
            }
            if (data.containsKey(m)) {
                System.out.println(data.get(m));
            } else {
                System.out.println(lastNum * m);
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean isRightNum(int num, int n) {
        boolean result = false;
        String[] numStrs = String.valueOf(num).split("");
        int[] data = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            data[i] = Integer.parseUnsignedInt(numStrs[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += getCalcuteNum(data[i], n);
        }
        if (sum == num) {
            result = true;
        }
        return result;
    }

    public static int getCalcuteNum(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}

/*解法二
import java.util.*;

public class demo {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 3 || num > 7) {
            System.out.println(-1);
        } else {
            int temp = 1;
            int temp1 = 1;
            for (int i = 0; i < num - 1; i++) {
                temp = temp * 10;
                temp1 = temp1 * 10;
            }
            temp1 = temp1 * 10;
            int a = 1;
            int count = 0;
            for (int i = temp; i < temp1; i++) {
                int sum = 0;
                int change = i;
                for (int j = 0; j < num ; j++) {
                    a = change % 10;
                    change = change / 10;
                    sum =sum + (int) Math.pow(a, num);
                }
                if (sum == i) {
                    count++;
                    if (count == sc.nextInt()+1) {
                        System.out.println(i);
                    }
                }
            }
        }


    }
}*/

