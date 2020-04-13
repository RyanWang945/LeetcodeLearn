package 刷题.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/3/21 8:13
 * 9   7    target=4
 * 9-7=2 7-2=5 9-5=4 7-4=3  9-3=6
 * 34 5 6    29-5=24 24-5=19 19-5=14 14-5=9 9-5=4 5-4=1 1+5=6
 */
public class _365canMeasureWater {
    boolean flag=false;
    Set<Integer> set=new HashSet<>();
    public boolean canMeasureWater(int x, int y, int z) {
        if(x==z||y==z||Math.abs(x-y)==z||(x+y)==z)
            return true;
        int large=Math.max(x,y);
        int small=Math.min(x,y);
        int temp=large-small;
        dfs(large,small,temp,z);
        return flag;
    }
    private void dfs(int large,int small,int temp,int target){
        if((large+temp)==target||(small+temp)==target)
            flag=true;
        if(large>temp&&!set.contains(large-temp)) {
            set.add(large-temp);
            dfs(large, small, large - temp, target);
        }
        if(small>temp&&!set.contains(small-temp)) {
            set.add(small - temp);
            dfs(large, small, small - temp, target);
        }
        if(temp>small&&!set.contains(temp-small)){
            set.add(temp-small);
            dfs(large,small,temp-small,target);
        }


    }
}
