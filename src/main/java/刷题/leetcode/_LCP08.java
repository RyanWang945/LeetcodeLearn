package 刷题.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/4/18 19:20
 */
public class _LCP08 {

    private class Solution {
        /**
         * 二分查找
         */
        public int[] getTriggerTime2(int[][] increase, int[][] requirements) {
            int len1=increase.length;
            int len2=requirements.length;
            int[] a=new int[len1+1];
            int[] b=new int[len1+1];
            int[] c=new int[len1+1];
            for(int i=1;i<=len1;i++){
                a[i]=a[i-1]+increase[i-1][0];
                b[i]=b[i-1]+increase[i-1][1];
                c[i]=c[i-1]+increase[i-1][2];
            }
            int[] res=new int[len2];
            for(int i=0;i<len2;i++){
                if(requirements[i][0]==0&&requirements[i][1]==0&&requirements[i][2]==0) res[i]=0;
                else{
                    int left=0;
                    int right=len1;
                    if(!(a[right]>=requirements[i][0]&&b[right]>=requirements[i][1]&&c[right]>=requirements[i][2])){
                        res[i]=-1;
                        continue;
                    }
                    //如果mid有一个小于requirements，那么left这个点必然不行了，left=mid+1,但如果mid全都大于 requirements，那么right可以等于mid
                    while(left<right){
                        int mid=(left+right)/2;
                        if(!(a[mid]>=requirements[i][0]&&b[mid]>=requirements[i][1]&&c[mid]>=requirements[i][2])){
                            left=mid+1;
                        }else
                            right=mid;
                    }
                    res[i]=left;
                }
            }
            return res;

        }
        /**
         * bf，很显然超时了
         */
        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            if(increase.length==0||requirements.length==0) return new int[0];
            int[] res=new int[requirements.length];//结果数组
            int[] curr=new int[3];//当前积累资源数组
            int n=requirements.length;
            int len=increase.length;
            for(int i=0;i<n;i++){
                res[i]=-1;
            }
            List<Pair> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new Pair(i,requirements[i]));
            }
            Collections.sort(list);
            for(int index=0;index<=len;index++){
                for(int i=0;i<n;i++){
                    if(curr[0]<list.get(i).r[0])
                        break;
                    if(res[list.get(i).i]!=-1) continue;
                    if(curr[0]>=list.get(i).r[0]&&curr[1]>=list.get(i).r[1]&&curr[2]>=list.get(i).r[2]){
                        res[list.get(i).i]=index;
                    }
                }

                for(int j=0;j<3&&index<len;j++){
                    curr[j]+=increase[index][j];
                }

            }

            return res;
        }
    }
    class Pair implements Comparable{
        int i;
        int[] r;
        Pair(int i,int[] r){
            this.i=i;
            this.r=r;
        }
        @Override
        public int compareTo(Object o) {
            Pair obj=(Pair)o;
            if(this.r[0]!=obj.r[0])
                return this.r[0]-obj.r[0];
            else if(this.r[1]!=obj.r[1])
                return this.r[1]-obj.r[1];
            else
                return this.r[2]-obj.r[2];
        }
    }
}


