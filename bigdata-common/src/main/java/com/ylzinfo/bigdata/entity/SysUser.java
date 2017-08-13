package com.ylzinfo.bigdata.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser extends BaseEntity {

    // Fields
    private static final long serialVersionUID = 4378812963861428230L;


    private String realName;
    private String username;
    private String password;
    private String idCard;
    private String pcsName;
    private Date lastLoginDate;
    private String lastLoginDateStr;
    private String telephone;
    private String pcsid;
    private String pcspath;
    private String pcsCode;
    private String lastLoginIp;
    private Integer status;
    private Integer isLock;
    private Integer isOnline;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    private Integer loginNum;
    private String remark;
    private String linkEmail;


    



}