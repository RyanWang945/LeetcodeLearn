package 刷题.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/6/6 9:49
 */
public class _128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        int max=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int curNum=num;
                int curCnt=1;
                while(set.contains(curNum+1)){
                    curNum++;
                    curCnt++;
                }
                max=Math.max(max,curCnt);
            }
        }
        return max;
    }
    public int longestConsecutive2(int[] nums) {
        if(nums==null|nums.length==0) return 0;
        UnionFind uf=new UnionFind(nums);
        for(int i=0;i<nums.length;i++){
            if(uf.fatherMap.containsKey(nums[i]-1))
                uf.union(nums[i]-1,nums[i]);
        }
        return uf.max;
    }
    class UnionFind{
        int max=1;
        HashMap<Integer,Integer> fatherMap;
        HashMap<Integer,Integer> sizeMap;
        public UnionFind(int[] nums){
            fatherMap=new HashMap<>();
            sizeMap=new HashMap<>();
            for(int val:nums){
                fatherMap.put(val,val);
                sizeMap.put(val,1);
            }
        }
        public int findFather(int val){
            int father=fatherMap.get(val);
            if(father!=val)
                father=findFather(father);
            fatherMap.put(val,father);
            return father;
        }
        public void union(int a,int b){
            int aFather=findFather(a);
            int bFather=findFather(b);
            if(aFather!=bFather){
                int aFatherSize=sizeMap.get(aFather);
                int bFatherSize=sizeMap.get(bFather);
                fatherMap.put(aFather,bFather);
                sizeMap.put(bFather,aFatherSize+bFatherSize);
                max=Math.max(max,aFatherSize+bFatherSize);
            }
        }
    }
}
