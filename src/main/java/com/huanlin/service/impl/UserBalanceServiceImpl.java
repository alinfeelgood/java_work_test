package com.huanlin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huanlin.common.ErrorCode;
import com.huanlin.exception.BusinessException;
import com.huanlin.mapper.UserBalanceMapper;
import com.huanlin.model.entity.UserBalance;
import com.huanlin.service.UserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserBalanceServiceImpl extends ServiceImpl<UserBalanceMapper, UserBalance>
        implements UserBalanceService {
    @Override
    public BigDecimal getUserBalance(User userFromRequest) {
        //通过用户id查询UserBalance表获取到用户余额进行返回
        String id = userFromRequest.getId();
        QueryWrapper<UserBalance> wrapper = new QueryWrapper<>();
        wrapper.eq("userId",id);
        UserBalance userBalance = this.baseMapper.selectOne(wrapper);
        BigDecimal balance = userBalance.getBalance();
        return balance;
    }

    @Transactional
    @Override
    public String reduceCostHundred(User userFromRequest) {
        int userId = userFromRequest.getId();
        QueryWrapper<UserBalance> wrapper = new QueryWrapper<>();
        wrapper.eq("userId",userId);
        UserBalance userBalance = this.baseMapper.selectOne(wrapper);
        BigDecimal balance = userBalance.getBalance();
        if(balance < 100){
            throw  new  BusinessException(ErrorCode.OPERATION_ERROR,"余额不足，请充值");
        }
        int res = this.baseMapper.reduceCostHUndred(userId);
        String msg = "修改成功";
        if(res <= 0){
            //更改
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"更新用户余额失败");
        }else{
            return msg;
        }
    }

    @Override
    public String refundToUser(String id) {
        int res = this.baseMapper.refundToUser(id);
        String msg = "退款成功";
        if(res <= 0){
            throw new  BusinessException(ErrorCode.OPERATION_ERROR,"退款失败");
        }else {
            return msg;
        }
    }

    @Override
    public String getUserBalanceChanges(String id) {
        return null;
    }
}
