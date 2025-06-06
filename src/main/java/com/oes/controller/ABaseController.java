package com.oes.controller;


import com.oes.entity.enums.ResponseCodeEnum;
import com.oes.entity.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LongWei
 * @version 1.0
 * @date 2025/3/26 11:40
 */
public class ABaseController {

    private static final Logger logger = LoggerFactory.getLogger(ABaseController.class);

    protected static final String STATUC_SUCCESS = "success";

    protected static final String STATUC_ERROR = "error";

    public static <T> Result getSuccessResponseVO(T t) {
        Result<T> responseVO = new Result<>();
        responseVO.setStatus(STATUC_SUCCESS);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVO.setData(t);
        return responseVO;
    }

    public static <T> Result getFailResponseVO(T t) {
        Result<T> responseVO = new Result<>();
        responseVO.setStatus(STATUC_ERROR);
        responseVO.setCode(ResponseCodeEnum.CODE_405.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_405.getMsg());
        responseVO.setData(t);
        return responseVO;
    }
}
