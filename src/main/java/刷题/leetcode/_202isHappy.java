package 刷题.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/3/10 17:27
 */
public class _202isHappy {
    public boolean isHappy(int n) {
        if(n==1) return true;

        Set<Integer> set=new HashSet<>();
        int temp=n;
        set.add(n);
        while(true){
            List<Integer> list=new ArrayList<>();
            while(temp!=0){
                list.add(temp%10);
                temp=temp/10;
            }
            for(int i=0;i<list.size();i++){
                int a=list.get(i);
                temp=a*a+temp;
            }
            if(temp==1)
                return true;
            if(set.contains(temp))
                return false;
            set.add(temp);
        }
    }
}
