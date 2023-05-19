package com.huanlin.controller;

import com.huanlin.common.BaseResponse;
import com.huanlin.common.ErrorCode;
import com.huanlin.common.ResultUtils;
import com.huanlin.exception.BusinessException;
import com.huanlin.service.UserBalanceChangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user/balanceChanges")
public class UserBalanceChangesController {
    @Autowired
    UserBalanceChangesService userBalanceChangesService;

    /**
     * 获取用户金额变动操作明细
     * @param request
     * @return
     */
    @GetMapping("/getBalanceChanges")
    public BaseResponse<String> getUserBalanceChanges(HttpServletRequest request){
        User userFromRequest = userService.getLoginUser(request);

        if(userFromRequest == null){
            throw  new BusinessException(ErrorCode.OPERATION_ERROR,"请先进行登陆");
        }
        String id = userFromRequest.getId();
        String res = userBalanceChangesService.getUserBalanceChanges(id);
        return ResultUtils.success(res);
    }
}
