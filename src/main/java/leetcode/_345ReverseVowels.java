package leetcode;

import org.junit.jupiter.api.Test;

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
        while(index1<index2){
            char a=c[index1];
            char b=c[index2];
            if(!vowels.contains(a))
                index1++;
            if(!vowels.contains(b))
                index2--;
            if(vowels.contains(a)&&vowels.contains(b)){
                char temp=a;
                c[index1++]=b;
                c[index2--]=a;
            }
        }
        return String.valueOf(c);
    }
    @Test
    public void test_Null(){
        String a=" ";
        System.out.println(a.length());
        System.out.println(a);
        char[] chars = a.toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }
    }
    //private static HashSet<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    @Test
    public void testreverseVowels2(){
        String s="race a car";
        //String s="hello";
        System.out.println(reverseVowels2(s));
    }
    public String reverseVowels2(String s) {
        if(s.length()==1) return s;
        int start=0;
        char[] s1=s.toCharArray();
        int end=s1.length-1;
        while(start<end){
            if(!vowels.contains(s1[start]))
                start++;
            if(!vowels.contains(s1[end]))
                end--;
            if(vowels.contains(s1[start])&&vowels.contains(s1[end])){
                char temp=s1[start];
                s1[start]=s1[end];
                s1[end]=temp;
                //上面这三个无法通过部分用例，很奇怪 "race a car"
//                char temp=s.charAt(start);
//                s1[start]=s.charAt(end);
//                s1[end]=temp;
                start++;
                end--;
            }
        }
        return String.valueOf(s1);
    }
}
