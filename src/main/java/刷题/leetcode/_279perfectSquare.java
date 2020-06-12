package 刷题.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/5 10:49
 */
public class _279perfectSquare {
    private class Node{
        int val;
        int step;
        Node(int val,int step){
            this.val=val;
            this.step=step;
        }

    }
    public int numSquares(int n){
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(n,1));
        boolean[] record=new boolean[n+1];
        while(!queue.isEmpty()){
            int val=queue.peek().val;
            int step=queue.peek().step;
            queue.remove();
            for(int i=0;;i++){
                int nextVal=val-i*i;
                if(nextVal<0)
                    break;
                if(nextVal==0)
                    return step;//这里隐含了一个假设，就是数量最少的一定先遍历到0，所以直接就返回了
                if(record[nextVal]==false){
                   queue.add(new Node(nextVal,step+1));
                   record[nextVal]=true;
                }
            }
        }
        return -1;
    }
    protected boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    /**
     * 四平方定理
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }
    @Test
    public void test(){
        int size=1;
        System.out.println(size--==0);
        System.out.println(size);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(10);
        Integer peek = queue.peek();
        System.out.println(peek);
    }

}
