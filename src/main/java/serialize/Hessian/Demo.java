package serialize.hessian;

/**
 * ����
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016��03��16�� added
 */
public class Demo implements java.io.Serializable  {
    public boolean equals(Object v) {
        return v != null && getClass().equals(v.getClass());
    }

    public String toString() {
        return getClass().getName() + "[]";
    }
}
