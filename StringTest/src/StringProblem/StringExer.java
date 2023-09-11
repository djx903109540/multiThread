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

    //统计一个字符串在另一个字符串中出现的次数
    @Test
    public void Test3(){
        String str = "abkkcadkabkebfkabkskab";
        String target = "ab";
        int counter = 0;
        String substr = str;
        int subLen = str.length();
        while(substr.indexOf(target) != -1){
            counter++;
            int pos = substr.indexOf(target);
            int next = pos + target.length();
            if(next >= subLen){
                break;
            }
            substr = substr.substring(next, subLen);
            subLen = subLen - next;
        }
        System.out.println("目标字符串出现的次数是：" + counter + "次");
    }
}
