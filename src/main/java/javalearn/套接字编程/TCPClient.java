package javalearn.套接字编程;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Ryan
 * @date 2020/4/1 16:02
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        String sentence;//暂存用户输入的字符串
        String modifiedSentence;//暂存从服务器得到的响应字符串
        BufferedReader inFromUser=new BufferedReader(
                new InputStreamReader((System.in))
                //System.in将连接到标准输入，这段代码
                //允许客户机从键盘读取输入
        );
        Socket clientSocket=new Socket("hostname",6789);
        DataOutputStream outToServer=new DataOutputStream(
                clientSocket.getOutputStream()
        );
        BufferedReader inFromServer=new BufferedReader(
                new InputStreamReader( clientSocket.getInputStream())
        );
        sentence=inFromUser.readLine();
        outToServer.writeBytes(sentence+'\n');
        modifiedSentence=inFromServer.readLine();
        System.out.println("From server:"+modifiedSentence);
        clientSocket.close();
    }
}
