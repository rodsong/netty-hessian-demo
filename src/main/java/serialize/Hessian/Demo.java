package serialize.hessian;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê03ÔÂ16ÈÕ added
 */
public class Demo implements java.io.Serializable  {
    public boolean equals(Object v) {
        return v != null && getClass().equals(v.getClass());
    }

    public String toString() {
        return getClass().getName() + "[]";
    }
}
