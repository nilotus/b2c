package cn.edu.jit.b2c.exceptiion;

import cn.edu.jit.b2c.enums.ResultEnum;

/**
 * Created by ChenQF on 2018/1/21.
 */
public class CtrlException extends RuntimeException {
    private Integer code;

    public CtrlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
