package serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê04ÔÂ06ÈÕ added
 */
public class PerformTestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo("test",100);

        int loop =1000000;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os =null;
        long start = System.currentTimeMillis();
        for(int i = 0;i<loop;i++){
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long end = System.currentTimeMillis();

        System.out.println("jdk serializable cost time is :" + (end - start) +"ms");


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i<loop;i++){
            byte[] b = info.codeC(buffer);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("byte serializable cost time is :" + (endTime - startTime) +"ms");
    }
}
