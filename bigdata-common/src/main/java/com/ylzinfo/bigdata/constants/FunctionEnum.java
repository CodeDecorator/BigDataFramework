package com.ylzinfo.bigdata.constants;

/**
 * 
 * 功能枚举
 *
 * @since chenran, 2017年7月18日, 创建文件
 */
public enum FunctionEnum {

    login("登录"),
    sysManage("系统管理"),
    userManage("用户管理"),
    groupManage("组织管理"),
    roleManage("角色管理"),
    operateLogManage("操作日志")
    ;
    
    private FunctionEnum(String name){
        this.name = name;
    }
    
    private String name;

    public String getName() {
        return name;
    }
    
}
