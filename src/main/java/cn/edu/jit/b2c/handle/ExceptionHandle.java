package cn.edu.jit.b2c.handle;

import cn.edu.jit.b2c.exceptiion.CtrlException;
import cn.edu.jit.b2c.util.MSG;
import cn.edu.jit.b2c.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ChenQF on 2018/1/21.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public MSG handle(Exception e) {
        if (e instanceof CtrlException) {
            CtrlException ctrlException = (CtrlException) e;
            return ResultUtil.error(ctrlException.getCode(), ctrlException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
