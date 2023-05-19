CREATE TABLE `user_balance_changes` (
  `id` varchar(20) NOT NULL,
  `userId` varchar(20) NOT NULL COMMENT '用户id',
  `operationMsg` text NOT NULL COMMENT '操作明细',
  `isDelete` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除(0-未删除，1-已删除)',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `user_balance` (
  `id` varchar(19) NOT NULL,
  `userId` varchar(20) NOT NULL COMMENT '用户id',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `mobile` varchar(11) NOT NULL COMMENT '用户电话',
  `balance` decimal(10,2) NOT NULL COMMENT '用户余额',
  `isDelete` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（0-未删除，1-已删除）',
  `createTime` datetime NOT NULL COMMENT '创建日期',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4