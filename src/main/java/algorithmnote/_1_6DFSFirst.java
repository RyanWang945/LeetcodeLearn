package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/1/6 15:35
 */
public class _1_6DFSFirst {
    static int n=5,V=8,maxValue=0;
    static int[]w=new int[]{3,5,1,2,2};
    static int[]c=new int[]{4,5,2,1,3};
    public void dfs(int index,int sumW,int sumC){
        if(index==n){
            return;
        }

        dfs(index+1,sumW,sumC);
        if(sumW+w[index]<=V){
            if(sumC+c[index]>maxValue){
                maxValue=sumC+c[index];
            }
            dfs(index+1,sumW+w[index],sumC+c[index]);
        }

    }
    @Test
    public void test_dfs(){
        dfs(0,0,0);
        System.out.println(maxValue);
    }
}



//    static int n=5,V=8,maxValue=0;
//    static int[]w=new int[]{3,5,1,2,2};
//    static int[]c=new int[]{4,5,2,1,3};
//    public void dfs(int index,int sumW,int sumC){
//        if(index==n){
//            if(sumC>maxValue&&sumW<=V){
//                maxValue=sumC;
//            }
//            return;
//        }
//        dfs(index+1,sumW,sumC);
//        dfs(index+1,sumW+w[index],sumC+c[index]);
//    }




















//    static int n=5;
//    static int V=8;
//    static int maxValue=0;
//    static int[] w=new int[]{3,5,1,2,2};
//    static int[] c=new int[]{4,5,2,1,3};
//    public void dfs(int index,int sumW,int sumC){
//        if(index==n){
//            if(sumW<=V&&sumC>maxValue){
//                maxValue=sumC;
//            }
//            return;
//        }
//        dfs(index+1,sumW,sumC);
//        dfs(index+1,sumW+w[index],sumC+c[index]);
//
//    }
