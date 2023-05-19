package com.huanlin.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user_balance_changes
 */
@TableName(value ="user_balance_changes")
@Data
public class UserBalanceChanges implements Serializable {
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
     * 操作明细
     */
    private String operationMsg;

    /**
     * 是否删除(0-未删除，1-已删除)
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}