/*
■ 题目描述

        单词接龙的规则是：

        可用于接龙的单词首字母必须要前一个单词的尾字母相同；
        当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词；已经参与接龙的单词不能重复使用。
        现给定一组全部由小写字母组成单词数组，并指定其中的一个单词作为起始单词，进行单词接龙，
        请输出最长的单词串，单词串是单词拼接而成，中间没有空格。
        输入描述:

        输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N ；
        输入的第二行为一个非负整数，表示单词的个数N；
        接下来的N行，分别表示单词数组中的单词。
        输出描述:

        输出一个字符串，表示最终拼接的单词串。
        示例1  输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        0

        6

        word

        dd

        da

        dc

        dword

        d

        输出

        worddwordda

        说明

        先确定起始单词word，再接以d开头的且长度最长的单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出worddwordda。

        示例2  输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        4

        6

        word

        dd

        da

        dc

        dword

        d

        输出

        dwordda

        说明

        先确定起始单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出dwordda。
        备注:

        单词个数N的取值范围为[1, 20]；
        单个单词的长度的取值范围为[1, 30]；*/

import java.util.*;

public class demo14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<String> obj = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String point = "";
        for (int i = 0; i < n; i++) {
            if (i == k) {
                String content = scanner.nextLine();
                sb.append(content);
                point = content.substring(content.length() - 1);
                continue;
            }
            obj.add(scanner.nextLine());
        }
        int flag = 0;
        while (true) {
            TreeSet<String> set = new TreeSet();
            for (String s : obj) {
                if (s.startsWith(point)) {
                    set.add(s);
                }
            }
            if (set.size() == 0) {
                System.out.print(sb);
                break;
            }
            point = set.first().substring(set.first().length() - 1);
            String content = set.first();
            flag = Objects.requireNonNull(set.pollFirst()).length();
            for (String str : set) {
                if (flag < str.length()) {
                    flag = str.length();
                    point = str.substring(str.length() - 1);
                    content = str;
                }
            }
            obj.remove(content);
            sb.append(content);
        }
    }
}
