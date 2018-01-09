package cn.edu.jit.b2c.util;

/**
 * Created by ChenQF on 2018/1/7.
 */

/**
 * author : Mr.Chen
 *
 * 返回消息类
 * code : 状态信息
 * msg : 提示信息
 * data : 对象信息
 */
public class MSG {
    private int code;
    private String msg;
    private Object data;

    public MSG(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public MSG(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
