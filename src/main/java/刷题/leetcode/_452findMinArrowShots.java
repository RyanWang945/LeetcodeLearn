package 刷题.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ryan
 * @date 2020/2/29 9:11
 */
public class _452findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        Comparator c=new MyComparator();
        Integer[][] newPoints = new Integer[points.length][2];
        for(int i=0;i<points.length;i++){
            for(int j=0;j<2;j++){
                newPoints[i][j]=points[i][j];
            }
        }
        Arrays.sort(newPoints,c);
        int start=newPoints[0][0];
        int end=newPoints[0][1];
        int count=1;
        int minEnd=end;
        for(int i=1;i<newPoints.length;i++){
            if(newPoints[i][0]>=start&&newPoints[i][1]<=minEnd){
                minEnd=newPoints[i][1];
                continue;
            }else{
                count++;
                start=newPoints[i][0];
                end=newPoints[i][1];
            }
        }
        return count;
    }
}
class MyComparator implements Comparator<Integer[]> {


    @Override
    public int compare(Integer[] o1, Integer[] o2) {
        if(o1[0]<o2[0]){
            return -1;
        }else if(o1[0]>o2[0]){
            return 1;
        }else
            return 0;
    }
}
