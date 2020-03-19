package leetcode;

import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/3/19 19:07
 */
public class _20isValid {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(stack.size()==0){
                stack.push(chars[i]);
                continue;
            }
            if(!valid(stack.peek(),chars[i])){
                stack.push(chars[i]);
                continue;
            }

            if(valid(stack.peek(),chars[i])){
                stack.pop();
                continue;
            }
        }
        if(stack.size()==0)
            return true;
        else return false;
    }
    private boolean valid(char a,char b){
        if(a=='(')
            return b==')';
        if(a=='{')
            return b=='}';
        if(a=='[')
            return b==']';
        return false;
    }
}
