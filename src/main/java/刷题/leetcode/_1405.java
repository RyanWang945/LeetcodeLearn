package 刷题.leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/4/6 20:23
 */
public class _1405 {
    public String longestDiverseString(int a, int b, int c) {
        MyChar[] mychars=new MyChar[]{
                new MyChar('a',a),
                new MyChar('b',b),
                new MyChar('c',c)
        };
        StringBuilder sb=new StringBuilder();
        while(true){
            Arrays.sort(mychars);
            //先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置次多的字符
            if(sb.length()>=2&&
                    sb.charAt(sb.length()-1)==mychars[2].ch&&
                    sb.charAt(sb.length()-2)==mychars[2].ch){
                if(mychars[1].count-->0){
                    sb.append(mychars[1].ch);
                }else
                    break;
            }else{
                if(mychars[2].count-->0){
                    sb.append(mychars[2].ch);
                }else break;
            }
        }
        return sb.toString();
    }
    private class MyChar implements Comparable{
        char ch;
        int count;
        public MyChar(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
        public int compareTo(Object o){
            MyChar other=(MyChar) o;
            return this.count-other.count;
        }
    }
    class Node implements Comparable{
        char c;
        int count;
        public Node(char c,int count){
            this.c=c;
            this.count=count;
        }

        @Override
        public int compareTo(Object o) {
            Node obj=(Node) o;
            return this.count-obj.count;
        }
    }
}
