package 刷题.leetcode;

import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/6/11 9:21
 */
public class _739 {
    public int[] dailyTemperatures(int[] T) {
        Node[]nodes=new Node[T.length];
        for(int i=0;i<T.length;i++){
            nodes[i]=new Node(i,T[i]);
        }
        Stack<Node> stack=new Stack<>();
        int[] ans=new int[T.length];
        for(int i=0;i<nodes.length;i++){
            if(stack.isEmpty()){
                stack.push(nodes[i]);
                continue;
            }
            while(!stack.isEmpty()&&nodes[i].temp>stack.peek().temp){
                Node n=stack.pop();
                ans[n.day]=nodes[i].day-n.day;
            }
            stack.push(nodes[i]);
        }
        while(!stack.isEmpty()){
            Node n=stack.pop();
            ans[n.day]=0;
        }
        return ans;
    }
    class Node{
        int day;
        int temp;
        public Node(int day,int temp){
            this.day=day;
            this.temp=temp;
        }
    }
}
