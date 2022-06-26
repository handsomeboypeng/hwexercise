import java.util.*;


/*■ 题目描述

        【组成最大数】

        小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。

        输入描述

        “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人。

        输出描述

        最大的数字字符串

        示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        22,221

        输出

        22221

        示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

        输入

        4589,101,41425,9999

        输出

        9999458941425101*/

public class demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : split) {
            int ch = Integer.parseInt(String.valueOf(s.charAt(0)));
            List<String> def = map.getOrDefault(ch, new ArrayList<>());
            def.add(s);
            map.put(ch, def);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >0 ; i--) {
            if (map.containsKey((Object) i )) {
                List<String> strings = map.get(i);
                sb.append(getChangeList(strings));
            }
        }
        System.out.println(sb);
    }

    private static String getChangeList(List<String> list){
        LinkedList<String> linkList = new LinkedList<>(list);
        StringBuilder sb = new StringBuilder();
        while (linkList.size() > 0){
            String tem = linkList.get(0);
            boolean flag = true;
            if (tem.length() != 1){
                for (int i = 1; i < linkList.size(); i++) {
                    if (compareMax(tem,linkList.get(i))){//tem不是当前最大值
                        linkList.remove(0);
                        linkList.addLast(tem);
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                sb.append(tem);
                linkList.remove(0);
            }
        }
        return sb.toString();
    }
    private static boolean compareMax(String idx0,String idx1){
        int idx1Length = idx0.length();
        int idx2Length = idx1.length();
        int length =Math.min(idx1Length,idx2Length);
        for (int i = 1; i < length; i++) {
            int i1 = Integer.parseInt(String.valueOf(idx0.charAt(i)));
            int i2 = Integer.parseInt(String.valueOf(idx1.charAt(i)));
            if (i1 != i2){
                return i2 - i1 > 0;
            }
        }
        return idx2Length == length;
    }
}

/*解法2
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(",");
        int len = str.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Integer.parseInt(str[i] + str[j]) < Integer.parseInt(str[j] + str[i])) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }

        System.out.println(res);
    }
}*/
