package com.ylzinfo.bigdata.constants;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * 操作日志-日志类型枚举
 *
 * @since chenran, 2017年7月18日, 创建文件
 */
public enum OperLogEnum {
    
    LOGOUT(-1, "退出系统"),
    LOGIN(0, "登录"),
    QUERY(1, "查询"),
    ADD(2, "添加"),
    EDIT(3, "修改"),
    DEL(4, "删除"),
    ANALYSIS(5, "分析"),
    IMPORT(6, "导入/上传"),
    EXPORT(7, "导出/下载"),
    APPROVE(8, "审核");
    
    private static final Logger logger = LoggerFactory.getLogger(OperLogEnum.class);
    
    private OperLogEnum(int code, String name){
        this.code = code;
        this.name = name;
    }
    
    private String name;
    private int code;
    public String getName() {
        return name;
    }
    public int getCode() {
        return code;
    }
    
    /**
     * 获取操作日志类型
     * @param code
     * @return
     * @since chenran, 2017年7月18日, 新增方法
     */
    public static String getOperType(int code){
        for(OperLogEnum type : OperLogEnum.values()){
            if(type.getCode() == code){
                return type.getName();
            }
        }
        return null;
    }
    
    /**
     * 获取操作日志类型
     * @param codeStr
     * @return
     * @since chenran, 2017年7月18日, 新增方法
     */
    public static String getOperType(String codeStr){
        if(StringUtils.isEmpty(codeStr)){
            return null;
        }
        try {
            int code = Integer.parseInt(codeStr);
            return getOperType(code);
        } catch (NumberFormatException e) {
            logger.error("转换操作类型失败", e);
            return null;
        }
    }
    
}
