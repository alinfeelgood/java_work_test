package com.huanlin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huanlin.model.entity.UserBalance;

/**
 * @Entity generator.domain.InterfaceError
 */
public interface UserBalanceMapper extends BaseMapper<UserBalance> {


    int reduceCostHUndred(int userId);

    int refundToUser(String id);
}




