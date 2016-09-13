package serialize;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê04ÔÂ06ÈÕ added
 */
public class UserInfo implements Serializable {

    private String name;
    private int id;

    public UserInfo(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public UserInfo buildUserName(String name) {
        this.name = name;
        return this;
    }

    public UserInfo buildUserID(int id) {
        this.id = id;
        return this;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.name.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);

        buffer.putInt(this.id);
        buffer.flip();
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.name.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.id);
        buffer.flip();

        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
