package com.ylzinfo.bigdata.entity;


import lombok.Data;

import java.util.Date;

@Data
public class SysDepartment extends BaseEntity {
    private static final long serialVersionUID = 1478115885985484818L;
    private Integer orderNum;
    private String name;
    private Integer num;
    private String path;
    private String parentId;
    private String aliasName;
    private String code;
    private String areaName;
    private String areaId;
    private Integer state;
    private Date createTime;
    private String creatorId;
    private Date updateTime;
    private String address;
    private String officePhone;
    private String contactor;
    private String contactorPhone;
    /** 父单位名称 */
    private String parentName;
    /** 父单位Path */
    private String parentPath;
    private String remark;
    /** 用户数 */
    private Integer userCount;

}