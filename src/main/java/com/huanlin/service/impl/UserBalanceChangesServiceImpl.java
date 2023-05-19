package com.huanlin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huanlin.mapper.UserBalanceChangesMapper;

import com.huanlin.model.entity.UserBalanceChanges;
import com.huanlin.service.UserBalanceChangesService;
import org.springframework.stereotype.Service;


@Service
public class UserBalanceChangesServiceImpl extends ServiceImpl<UserBalanceChangesMapper, UserBalanceChanges>
        implements UserBalanceChangesService {

    @Override
    public String getUserBalanceChanges(String id) {
        QueryWrapper<UserBalanceChanges> wrapper = new QueryWrapper<>();
        wrapper.eq("userId",id).orderByDesc("createTime").last("limit 1");
        UserBalanceChanges balanceChanges = this.baseMapper.selectOne(wrapper);
        return balanceChanges.getOperationMsg();
    }
}
