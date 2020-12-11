package javalearn.IO编程;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Ryan
 * @date 2020/8/8 9:52
 */
public class 输出流demo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        generateCharacters(outputStream);
        //这个out似乎直接指向控制台，然后生成后直接输出了
        outputStream.close();
    }
    public static void generateCharacters(OutputStream out) throws IOException {
        int f=33;
        int n=94;
        int start=f;
        byte[] line=new byte[n+2];
        int j=1;
        while(j==1){
            for(int i=start;i<start+n;i++){
                line[i-start]=(byte)((i-f)%n+f);
            }
            line[72]=(byte)'\r';
            line[73]=(byte)'\n';
            out.write(line);
            start=((start+1)-f)%n+f;
            j++;
        }
    }
}
