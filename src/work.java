import java.util.*;

public class work {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
        String s = sc.nextLine();
        String [] ss = s.split(" ");
//        缺勤不超过一次；没有连续的迟到/早退；任意连续7次考勤，缺勤/迟到/早退不超过3次
//        bsent：缺勤
//
//late：迟到
//
//leaveearly：早退
//
//present：正常上班
        int countabsent = 0;
        int count = 0;
        for(int i = 0; i < ss.length; i++){
            if (count >=2) {
                System.out.println("false");
                return;
            }
            if (ss[i].equals("absent")){
                countabsent ++;
            }
            if (ss[i].equals("late") || ss[i].equals("leaveearly")) {
                count++;
            } else{
                count = 0;
            }
        }
        if (countabsent > 1) {
            System.out.println("false");
            return;
        }
        int countk = 0;
        for (int j = 0; j <= ss.length - 7; j++) {
            for (int k = 0; k < j + 6; k ++) {
                if (ss[k].equals("late") || ss[k].equals("leaveearly") || ss[k].equals("absent")) {
                    countk++;
                }
                if (countk >= 2) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }
}
