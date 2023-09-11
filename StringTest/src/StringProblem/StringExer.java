package StringProblem;

import org.junit.Test;

public class StringExer {


    //去除字符串两端的空格
    @Test
    public void Test1(){
        String str = "     my trim";
        int len = str.length();
        int leftBlank = 0;
        int rightBlank = 0;
        for(leftBlank = 0; leftBlank < len; leftBlank++){
            if(str.charAt(leftBlank) != ' '){
                break;
            }
        }
        for(rightBlank = len - 1; rightBlank > 0; rightBlank--){
            if(str.charAt(rightBlank) != ' '){
                break;
            }
        }
        String str1 = str.substring(leftBlank, rightBlank + 1);
        System.out.println(str1);
    }

}
