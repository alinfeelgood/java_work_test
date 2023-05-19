package com.huanlin.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName user_balance
 */
@TableName(value ="user_balance")
@Data
public class UserBalance implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户电话
     */
    private String mobile;

    /**
     * 用户余额
     */
    private BigDecimal balance;

    /**
     * 是否删除（0-未删除，1-已删除）
     */
    private Byte isDelete;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}