/*■ 题目描述

        【机器人走迷宫】

        机器人走一个迷宫，给出迷宫的x和y(x*y的迷宫)并且迷宫中有障碍物,输入k表示障碍物有k个，并且会将障碍物的坐标挨个输入。

        机器人从0,0的位置走到x,y的位置并且只能向x,y增加的方向走，不能回退，

        如代码类注释展示的样子，#表示可以走的方格，0代表障碍，机器人从0,0的位置只能向下或者向前走到出口，

        其中会有不可达方格和陷阱方格。

        不可达方格为第四行前三个，该机器人在行走路径上不可能走到的方格，陷阱方格如第一行最后两个，走进之后则不能抵达终点。

        要求: 输出陷阱和不可达方格方格数量。*/
import java.util.Scanner;

public class demo11 {
    private static int n1;
    private static int m1;
    private static int endX1;
    private static int endY1;
    private static int[][] arr;
    private static boolean[][] mark;
    private static int trip =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nms = sc.nextLine().split(" ");
        n1 = Integer.parseInt(nms[1]);
        m1 = Integer.parseInt(nms[0]);
        arr = new int[n1][m1];
        mark = new boolean[n1][m1];
        int x1 = n1 - 1;
        int y1 = 0;
        endX1 = 0;
        endY1 = m1 - 1;
        int wellCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < wellCount; i++) {
            String[] wall = sc.nextLine().split(" ");
            int weX1 = n1 -1 - Integer.parseInt(wall[1]);
            int weY1 = Integer.parseInt(wall[0]);
            arr[weX1][weY1] = 1;
        }
        arr[x1][y1] = 2;
        dfs(x1, y1);
        int unReach = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                if (arr[i][j] == 0){
                    unReach++;
                    System.out.println(i + ":" + j);
                }
            }
        }
        System.out.println(trip + " " + unReach);
    }

    private static boolean dfs(int x1,int y1){
        boolean flag = false;
        if (x1 == endX1 && y1 == endY1){
            return true;
        }
        int[][] next = {{-1,0},{0,1}};
        int nextX1 = 0;
        int nextY1 = 0;
        for (int i = 0; i < 2; i++) {
            nextX1 = x1 + next[i][0];
            nextY1 = y1 + next[i][1];
            if (nextX1 < 0 || nextY1 >=m1 ){
                continue;
            }
            if (arr[nextX1][nextY1] != 1 && !mark[nextX1][nextY1]){
                mark[nextX1][nextY1] = true;
                arr[nextX1][nextY1] = 2;
                boolean dfs = dfs(nextX1, nextY1);
                if (flag || dfs){
                    flag = true;
                }
                mark[nextX1][nextY1] = false;
            }
        }
        if (!flag){
            trip++;
            System.out.println(x1 + ":" + y1);
        }

        return flag;
    }
}
