package 刷题.leetcode;

import java.util.HashMap;

/**
 * @author Ryan
 * @date 2020/5/11 10:48
 */
public class _166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num=numerator;
        long den=denominator;
        String sign="";
        if(num>0&&den<0||num<0&&den>0)
            sign="-";
        num=Math.abs(num);
        den=Math.abs(den);
        long integer=num/den;
        num=num-integer*den;
        HashMap<Long,Integer> map=new HashMap<>();
        int index=0;
        String decimal="";
        int repeatIndex=-1;
        while(num!=0){
            num*=10;
            if(map.containsKey(num)){
                repeatIndex=map.get(num);
                break;
            }
            map.put(num,index);
            long decimalPlace=num/den;
            decimal=decimal+decimalPlace;
            num=num-decimalPlace*den;
            index++;
        }
        if(repeatIndex!=-1){
            String dec=decimal;
            return sign+integer+"."+dec.substring(0,repeatIndex)+"("+dec.substring(repeatIndex)+")";
        }else{
            if(decimal=="")
                return sign+integer;
            else return sign+integer+"."+decimal;
        }
    }
}
