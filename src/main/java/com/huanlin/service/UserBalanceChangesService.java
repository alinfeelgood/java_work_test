package com.huanlin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huanlin.model.entity.UserBalance;
import com.huanlin.model.entity.UserBalanceChanges;

import java.math.BigDecimal;

public interface UserBalanceChangesService extends IService<UserBalanceChanges> {


    String getUserBalanceChanges(String id);
}
