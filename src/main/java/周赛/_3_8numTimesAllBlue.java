package 周赛;

/**
 * @author Ryan
 * @date 2020/3/8 10:43
 */
public class _3_8numTimesAllBlue {
    public int numTimesAllBlue(int[] light) {
        int count=0;
        int[] table=new int[light.length];
        int last=0;
        for(int i=0;i<light.length;i++){
            table[light[i]]=1;
            if(isValid(table,last,i)){
                count++;
                last=i;
            }
        }
        return count;
    }
    public boolean isValid(int[] table,int last,int i){
        for(int j=last;j<=i;j++){
            if(table[j]==1)
                continue;
            else return false;
        }
        return true;
    }
}
