package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/2/29 10:13
 */
public class _763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] hashtable=new int[128];
        for(int i=0;i<S.length();i++){
            hashtable[(int)S.charAt(i)]=i;
        }
        List<Integer> ans=new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=0;i<S.length();i++){
            end=Math.max(end,hashtable[S.charAt(i)]);
            if(end==i){
                ans.add(end-start+1);
                start=end+1;
            }
        }
        return ans;
    }
}
