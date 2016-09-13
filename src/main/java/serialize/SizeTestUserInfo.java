package serialize;

import com.demo.pojo.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê04ÔÂ06ÈÕ added
 */
public class SizeTestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo("test",100);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);

        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();

        System.out.println("jdk serializable length is : " +b.length);
        System.out.println("byte array serializable length is : " +info.codeC().length);
        System.out.println(b.length / info.codeC().length+" fold.");
    }
}
