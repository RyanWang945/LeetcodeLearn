package javalearn.userMethod;

import java.io.*;

/**
 * @author Ryan
 * @date 2020/8/11 15:25
 */
public class Remote {
    public static void main(String[] args) throws IOException {
        Process proc = Runtime.getRuntime().exec("java javalearn.userMethod.Fibonacci 20");
        InputStream inputStream = proc.getInputStream();
        System.out.println("Success");
        read(inputStream,System.out);
        System.out.println("success end");
    }
    private static void read(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
