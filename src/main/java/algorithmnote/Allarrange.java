package algorithmnote;

import java.util.Map;

/**
 * 全排列的基本算法
 * @author Ryan
 * @date 2019/12/30 17:53
 * boolean初始化就是false
 */
public class Allarrange {
    int n=8;
    boolean[] hashtable=new boolean[11];
    int[] p=new int[n+1];
    static int counter=0;
    void generate(int index){
        if(index==n+1){
            for(int i=1;i<n+1;i++){
                System.out.print(p[i]);
            }
            counter++;
            System.out.println();
            return;

        }
        for(int i=1;i<=n;i++){
            if(hashtable[i]==false){
                boolean flag=true;
                for(int pre=1;pre<index;pre++){
                    if(Math.abs(index-pre)== Math.abs(i-p[pre])){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    p[index]=i;
                    hashtable[i]=true;
                    generate(index+1);
                    hashtable[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Allarrange a=new Allarrange();
        a.generate(1);
        System.out.println(a.counter);
    }
}
