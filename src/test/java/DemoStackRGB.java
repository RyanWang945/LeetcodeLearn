import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/3/29 21:07
 */
public class DemoStackRGB {
    public void test(int n,char[] chs){
        Stack<Character> stack=new Stack<>();
        int[] dp=new int[n];
        dp[0]=3;
        int index=1;
        stack.push(chs[0]);
        while(index!=n-1){
            if(chs[index]==')'&&stack.peek()=='(') {
                dp[index++] = 2;
                stack.pop();
                stack.push(chs[index]);
            }else{
                dp[index]=2;
            }
        }
    }
}
