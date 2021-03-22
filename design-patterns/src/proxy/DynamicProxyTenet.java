package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-20 13:01
 * @Version 1.0
 */
public class DynamicProxyTenet {
    public static void main(String[] args) {
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream write=null;
        try {
            write = new FileOutputStream("$Proxy0.class");
            write.write($Proxy0s);
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(write!=null){
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
