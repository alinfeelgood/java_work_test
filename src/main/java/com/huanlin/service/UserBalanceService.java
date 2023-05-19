package com.huanlin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huanlin.model.entity.UserBalance;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface UserBalanceService extends IService<UserBalance> {

    BigDecimal getUserBalance(User userFromRequest);

    String reduceCostHundred(User userFromRequest);

    String refundToUser(String id);

    String getUserBalanceChanges(String id);
}
