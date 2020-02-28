package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * 递归实现反向打印字符串
 * @author Ryan
 * @date 2020/1/3 13:48
 */
public class PrintReverse {
    void printReverse(char[] str){
        helper(0,str);
    }
    private static void helper(int index,char[] str){
        if(str==null||index>=str.length){
            return;
        }
        helper(index+1,str);
        System.out.println(str[index]);
    }
    @Test
    public void test_printreverse(){
        char[] str={'r','y','a','n'};
        PrintReverse p=new PrintReverse();
        p.printReverse(str);
    }
}
