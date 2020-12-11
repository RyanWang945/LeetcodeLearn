package javalearn.正则表达式;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/20 11:17
 */
public class QQDemo {
    public static void main(String[] args) {

    }
    public static boolean checkQQ(String qq){
        //首先判断是否为null
        if(qq==null)
            return false;
        else{
            //判断长度
            if(qq.length()>=4){
                boolean rs=true;
                //遍历每个字符
                for(int i=0;i<qq.length();i++){
                    char ch=qq.charAt(i);
                    if(ch<'0'||ch>'9')
                        rs=false;
                }
                return rs;
            }else
                return false;
        }
    }
    public static boolean checkQQRegex(String qq){
        return qq!=null&&qq.matches("\\d{4,}");
    }
    @Test
    public void test(){
//        System.out.println("a".matches("[abc]"));//true
//        System.out.println("z".matches("[abc]"));//false
//        System.out.println("a".matches("[^abc]"));//false
//        System.out.println("z".matches("[^abc]"));//true
//        System.out.println("z".matches("\\d"));//false
//        System.out.println("3".matches("\\d"));//true
//        System.out.println("z".matches("\\w"));//true
//        System.out.println("2".matches("\\w"));//true
//        System.out.println("你".matches("\\w"));//false
//        System.out.println("21".matches("\\w"));//false 以上都只能匹配一个
        //校验密码
        //必须是数字 字母下划线，至少6位
        System.out.println("s21".matches("\\w{6,}"));//false
        System.out.println("sdaffawe".matches("\\w{6,}"));//true
        System.out.println("adfa你".matches("\\w{6,}"));//false 有中文
        System.out.println("dfs2".matches("[a-zA-Z0-9]{4}"));//true
    }
}
