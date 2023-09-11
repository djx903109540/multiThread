package StringProblem;

import org.junit.Test;

public class StringExer {


    //去除字符串两端的空格
    @Test
    public void Test1(){
        String str = "     my trim";
        int len = str.length();
        int leftBlank;
        int rightBlank;
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

    //指定字符串反转
    @Test
    public void Test2(){
        String str = "abcdefg";
        int start = 3;
        int end = 6;
        char[] arr = str.toCharArray();
        while (start  < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        String res = new String(arr);
        System.out.println(res);
    }
}
