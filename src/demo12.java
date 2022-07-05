/*
■ 题目描述

        【移除 K 位数字的最小值】

        输入描述

        第一行输入一个非负整数字符串，第二行输入一个整数n

        输出描述

        输出从该字符串中取出n个字符后剩下的字符组成的最小的数（不改变字符顺序）

        输入

        2615371

        4

        输出

        131

        给出一个数字组成的字符串，去除指定个数的字符，剩余的组成最小值。

        这个解题思路可以是递归，按照顺序取剩余个数的字符，组成数字，依次比较获取，但是可能超时。

        例如 6525441，去除 4 个字符，得到 241。

        最优解是删除出现的第一个左边>右边的数，

        例如第一次删除 6，因为 6>5，变成 525441；

        第二次删除 5，5>2，变成 25441，第三次是 5，第四次是 4，结果为 241。

*/
import java.util.*;

public class demo12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int m = sc.nextInt();
        int l = m + 1;
        int index = 0;
        StringBuilder res = new StringBuilder();

        while (res.length() < s.length() - m) {
            String str = s.substring(index, l);
            int min = Integer.MAX_VALUE;
            int len = str.length();
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                int temp = str.charAt(i) - '0';
                ints[i] = temp;
                if (res.toString().equals("") && temp == 0) {
                    continue;
                }
                min = Math.min(min, temp);
            }
            res.append(min);

            for (int i = 0; i < len; i++) {
                if (ints[i] == min) {
                    index += i;
                    break;
                }
            }
            index++;
            l++;
        }
        System.out.println(res);
    }
}