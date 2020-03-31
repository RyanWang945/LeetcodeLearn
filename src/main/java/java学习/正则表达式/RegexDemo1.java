package java学习.正则表达式;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/3/20 15:25
 */
public class RegexDemo1 {
    public static void main(String[] args) {
        //校验邮箱
        //checkEmail();
        checkTel();
    }
    public static void checkEmail(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请您输入邮箱");
        String email=sc.nextLine();
        //\\.有些意思，第一个\代表转义，它就是个. ，第二个是正则表达式表达他不是特殊用途
        if(email.matches("\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2}")){
            System.out.println("邮箱格式合法");
        }else
            System.err.println("格式不正确");
    }
    public static void checkTel(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请您输入手机号");
        String email=sc.nextLine();
        //\\.有些意思，第一个\代表转义，它就是个. ，第二个是正则表达式表达他不是特殊用途
        if(email.matches("1[3-9]\\d{9}")){
            System.out.println("手机格式合法");
        }else
            System.err.println("格式不正确");
    }
    public static void checkPh(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请您输入电话号");
        String email=sc.nextLine();
        //\\.有些意思，第一个\代表转义，它就是个. ，第二个是正则表达式表达他不是特殊用途
        if(email.matches("0\\d{2,5}-?\\d{5,15}")){
            System.out.println("电话号格式合法");
        }else
            System.err.println("格式不正确");
    }
}
