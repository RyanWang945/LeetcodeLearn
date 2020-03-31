package leetcode;

import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/3/19 19:18
 */
public class _155MinStack {
}
class MinStack {

    /** initialize your data structure here. */
    int min=Integer.MAX_VALUE;
    int[] stack=new int[100005];
    int top;
    public MinStack() {
        top=-1;
    }

    public void push(int x) {
        stack[++top]=x;
        if(x<min){
            min=x;
        }

    }

    public void pop() {
        int x=stack[top--];
        if(x==min){
            min=Integer.MAX_VALUE;
            for(int i=0;i<=top;i++){
                if(min>stack[i])
                    min=stack[i];
            }
        }
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return min;
    }
}
class MinStack2 {
    private Stack<Integer> stack;
    private int min;
    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min ){//注意：这里要使用<=号
            stack.push(min);//在每一个min入栈之前将它前一个min入栈
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min){//如果取出来的是当前min，就将压在它低下的前一个min出栈
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
