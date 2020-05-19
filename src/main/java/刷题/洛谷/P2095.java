package 刷题.洛谷;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/5/18 20:43
 */
public class P2095 {
    public static void main(String[] args) throws IOException {
        int C=System.in.read();
        C-='0';
        int H=System.in.read();
        H-='0';
        System.out.println(C);
        System.out.println(H);
        int[] v=new int[H+1];
        for(int index=1;index<=H;index++){
            v[index]=System.in.read();
            v[index]-='0';
        }
        int[] f=new int[C+1];
        for(int i=1;i<=H;i++){
            for(int j=C;j>=v[i];j--)
                f[j]=Math.max(f[j],f[j-v[i]+v[i]]);
            if(f[C]==C)
                System.out.println(C);
        }
        System.out.println(0);

    }
}
