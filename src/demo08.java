/*■ 题目描述

        【水仙花数】

        给定非空字符串s，将该字符串分割成一些子串，使每个子串的ASCII码值的和均为水仙花数。

        1、若分割不成功，则返回0；

        2、若分割成功且分割结果不唯一，则返回-1；

        3、若分割成功且分割结果唯一，则返回分割后子串的数目。

        输入描述

        输入字符串的最大长度为200

        输出描述

        根据题目描述中情况，返回相应的结果。

        示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        abc

        输出

        0

        说明

        分割不成功

        示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

        隐藏内容
        输入

        f3@d5a8

输出

        -1

        说明

        分割成功但分割结果不唯一，可以分割为两组，一组”f3″和”@d5a8″，另外一组”f3@d5″和”a8″。

        a:97,8:56，两者相加为153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

        示例3 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        AXdddF

        输出

        2

        说明

        成功分割且分割结果唯一，可以分割为”AX”(153)和”dddF”(370)两个子串。

        A:65

        X:64+26-2=88

        65+88=153

        d:97+3=100

        dddF = 100 * 3 + 70 = 370 = 3^3+7^3 = 27 + 343 = 370*/

import java.util.*;

public class demo08 {

    public static int fuhe = 0;
    public static int zichuan = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int res = 0;

        fenge(str);

        if (fuhe == 1) {
            res = zichuan;
        } else if (fuhe > 1) {
            res = -1;
        }

        System.out.println(res);

    }

    public static void fenge(String s) {

        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += s.charAt(i);
            if (count > 999) {
                break;
            }
            if (count >= 100) {
                if (isSXS(count)) {
                    if (i == len - 1) {
                        fuhe++;
                    } else {
                        fenge(s.substring(i + 1));
                        zichuan++;
                    }
                }
            }
        }
    }

    public static boolean isSXS(int i) {

        int b = i / 100;
        int s = i % 100 / 10;
        int g = i % 100 % 10;

        int count = (int) (Math.pow(b, 3) + Math.pow(s, 3) + Math.pow(g, 3));

        return count == i;
    }
}