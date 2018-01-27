package cn.edu.jit.b2c.util;

/**
 * Created by ChenQF on 2018/1/21.
 */
public class ResultUtil {

    public static MSG success(Object object) {
        MSG result = new MSG();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static MSG success() {
        return success(null);
    }

    public static MSG error(Integer code, String msg) {
        MSG result = new MSG();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}