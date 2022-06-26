import java.util.*;

public class Stringspilt {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] ss = s.split("-");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ss[0]);
        StringBuffer stringBuffer1 = new StringBuffer();
        int n = 3;
        s.replace("-","");
        int lowcount1 = 0;
        int highcount1 =0 ;
        if ((s.replace("-","").length() - stringBuffer.length()) < n) {
            for(int m = 1;m < ss.length;m++){
                for(int mm = 0;mm < ss[m].length();mm++){
                    if (ss[m].charAt(mm) >= 'a' &&  ss[m].charAt(mm) < 'z') {
                        lowcount1 ++;
                    } else if (ss[m].charAt(mm) >= 'A' &&  ss[m].charAt(mm) < 'Z'){
                        highcount1++;
                    }
                }
            }
            String ssss ="";
            String ssss1 = "";
            if (lowcount1 > highcount1) {
                for (int mmm = 1;mmm<ss.length;mmm++){
                    ssss +=ss[mmm];
                }
                ssss1 = ssss.toLowerCase();
                stringBuffer.append("-" + ssss1);
            } else if (lowcount1 < highcount1){
                for (int mmm = 1;mmm<ss.length;mmm++){
                    ssss +=ss[mmm];
                }
                ssss1 = ssss.toUpperCase();
                stringBuffer.append("-"+ssss1);
            } else {
                for (int mmm = 1;mmm<ss.length;mmm++){
                    ssss +=ss[mmm];
                }
                ssss1 = ssss;
                stringBuffer.append("-" + ssss1);
            }
            System.out.println(stringBuffer.toString());

            return;
        } else{
            for (int i = 1; i < ss.length;i ++){
                stringBuffer1.append(ss[i]);
            }
            if (stringBuffer1.length() < n) {
                stringBuffer.append("-" + stringBuffer1.toString());
                System.out.println(stringBuffer.toString());
                return;
            }
            for(int j = 0;j < ((stringBuffer1.length() % n) == 0 ? (stringBuffer1.length() / n)  : stringBuffer1.length() / n +1);j++) {
                String sss = "";
                if (j*n + n < stringBuffer1.length()) {
                    sss = stringBuffer1.substring(j*n,j*n+n);
                } else {
                    sss = stringBuffer1.substring(j*n, stringBuffer1.length());
                }
                int lowcount = 0;
                int highcount = 0;
                for (int k  = 0; k < sss.length();k++){
                    if (sss.charAt(k) >= 'a' &&  sss.charAt(k) < 'z') {
                        lowcount ++;
                    } else if (sss.charAt(k) >= 'A' &&  sss.charAt(k) < 'Z'){
                        highcount++;
                    }
                }
                String temp = "";
                if (lowcount > highcount) {
                    temp = sss.toLowerCase();
                    stringBuffer.append("-" + temp);
                } else if (highcount > lowcount) {
                    temp=sss.toUpperCase();
                    stringBuffer.append("-"+temp);
                } else{
                    stringBuffer.append("-" + sss);
                }


            }
        }

        System.out.println(stringBuffer.toString());


    }
}
