package com.huanlin.controller;

import com.huanlin.common.BaseResponse;
import com.huanlin.common.ErrorCode;
import com.huanlin.common.ResultUtils;
import com.huanlin.exception.BusinessException;
import com.huanlin.model.entity.UserBalance;
import com.huanlin.service.UserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RequestMapping("/user/balance")
@RestController
public class UserBalanceController {

    @Autowired
    UserBalanceService userBalanceService;
    /**
     * 获取用户余额
     * 通过用户登录的用户态 获取当前登录用户信息（代码省略）
     * @param request
     * @return
     */
    @GetMapping("/getUserBalance")
    public BaseResponse<BigDecimal> getUserBalance(HttpServletRequest request){
        User userFromRequest = userService.getLoginUser(request);

        if(userFromRequest == null){
            throw  new BusinessException(ErrorCode.OPERATION_ERROR,"请先进行登陆");
        }
        BigDecimal userBalance = userBalanceService.getUserBalance(userFromRequest);
        return ResultUtils.success(userBalance);
    }

    /**
     * 用户消费一百元的接口
     * 通过用户态获取用户信息 再根据用户信息对用户余额表进行操作
     * @param request
     * @return
     */
    @GetMapping("/costHundred")
    public  BaseResponse<String> costHundred(HttpServletRequest request){
        User userFromRequest = userService.getLoginUser(request);

        if(userFromRequest == null){
            throw  new BusinessException(ErrorCode.OPERATION_ERROR,"请先进行登陆");
        }
        String result = userBalanceService.reduceCostHundred(userFromRequest);
        return  ResultUtils.success(result);
    }

    /**
     * 用户退款20元接口
     * @param request
     * @return
     */
    @GetMapping("/refund")
    public BaseResponse<String> refund(HttpServletRequest request){
        User userFromRequest = userService.getLoginUser(request);

        if(userFromRequest == null){
            throw  new BusinessException(ErrorCode.OPERATION_ERROR,"请先进行登陆");
        }
        String id = userFromRequest.getId();
        String res = userBalanceService.refundToUser(id);
        return ResultUtils.success(res);
    }


}
