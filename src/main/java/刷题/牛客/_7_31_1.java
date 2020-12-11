package 刷题.牛客;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/7/31 20:08
 * 链接：https://www.nowcoder.com/questionTerminal/0823ca800ee04706a7e2dafc837dc236
 * 来源：牛客网
 *
 * 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
 *  1.输入字符包括，"("    ,    ")"    和    "<"和其他字符。
 * 2.其他字符表示笔记内容。
 *  3.()之间表示注释内容，任何字符都无效。    括号保证成对出现。
 *  4."<"表示退格,    删去前面一个笔记内容字符。括号不受"<"影响    。
 */
public class _7_31_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] chs=sc.next().toCharArray();
        Stack<Character> stack=new Stack<>();
        int flag=0;
        for(int i=0;i<chs.length;i++){

            if(chs[i]=='<'&&flag==0){
                stack.pop();
            }else if(chs[i]=='('){
                stack.push('(');
                flag++;
            }else if(flag==0){
                stack.push(chs[i]);
            }else if(chs[i]==')'){
                stack.pop();
                flag--;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}
