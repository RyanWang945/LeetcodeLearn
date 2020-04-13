package 刷题.leetcode;

import org.junit.Test;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ryan
 * @date 2020/2/28 12:10
 * 包含了二维数组的使用
 * 二维数组并不是规则的矩阵，第一个维度存储的是数组的地址，第二个维度存储的是数组
 */
public class _435eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Comparator c=new MyComparator();
        Integer[][] newIntervals = new Integer[intervals.length][2];
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<2;j++){
                newIntervals[i][j]=intervals[i][j];
            }
        }
        Arrays.sort(newIntervals,c);
        int count=1;
        int end=(int)newIntervals[0][1];
        for(int i=1;i<newIntervals.length;i++){
            if(newIntervals[i][0]<end){
                continue;
            }
            end=newIntervals[i][1];
            count++;
        }
        return newIntervals.length-count;
    }
    class MyComparator implements Comparator<Integer[]>{


        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            if(o1[1]<o2[1]){
                return -1;
            }else if(o1[1]>o2[1]){
                return 1;
            }else
                return 0;
        }
    }


    @Test
    public void testComparator(){
        Integer[][] a={{3,4},{1,2},{2,3}};
        Comparator cmp=new MyComparator();;
        Arrays.sort(a,cmp);
    }

}
