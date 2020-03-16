package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/3 20:59
 */
public class _241diffWaysToCompute {
//    public List<Integer> diffWaysToCompute(String input){
//        if(input.length()==0){
//            return new ArrayList<>();
//        }
//        List<Integer> result=new ArrayList<>();
//        int num=0;
//        int index=0;
//        while(index<input.length()&&!isOperation(input.charAt(index))){
//            num=num*10+input.charAt(index)-'0';
//            index++;
//        }
//        if(index==input.length()){
//            result.add(num);
//            return result;
//        }
//        for(int i=0;i<input.length();i++){
//            if(isOperation(input.charAt(i))){
//                List<Integer> result1=diffWaysToCompute(input.substring(0,i));
//                List<Integer> result2=diffWaysToCompute(input.substring(i+1));
//                for(int j=0;j<result1.size();j++){
//                    for(int k=0;k<result2.size();k++){
//                        char op=input.charAt(i);
//                        result.add(caculate(result1.get(j),op,result2.get(k)));
//                    }
//                }
//            }
//        }
//    }
    private boolean isOperation(char c){
        HashSet<Character> set=new HashSet<>(Arrays.asList('*','+','-'));
        if(set.contains(c))
            return true;
        else return false;
    }
}
