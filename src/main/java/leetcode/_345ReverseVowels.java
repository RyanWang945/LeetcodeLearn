package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Ryan
 * @date 2020/2/25 12:09
 */
public class _345ReverseVowels {
    private static HashSet<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        //如何将String转为char数组
        char[] c=s.toCharArray();
        int index1=0;
        int index2=c.length-1;
        while(index1<=index2){
            char a=c[index1];
            char b=c[index2];
            if(!vowels.contains(a))
                index1++;
            if(!vowels.contains(b))
                index2++;
            if(vowels.contains(a)&&vowels.contains(b)){
                char temp=a;
                c[index1++]=b;
                c[index2++]=a;
            }
        }
        return String.valueOf(c);
    }
}
