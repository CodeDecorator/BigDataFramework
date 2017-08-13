/**   
 * Copyright (c) 2012-2022 厦门市美亚柏科信息股份有限公司.
 */
package com.ylzinfo.bigdata.controller;

import com.ylzinfo.bigdata.constants.BaseConstants;
import com.ylzinfo.bigdata.entity.SysDepartment;
import com.ylzinfo.bigdata.entity.SysUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Locale;


@Component
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    protected static final String ENCODING_DEFAULT = "UTF-8";
  /*  @Resource
    protected OperateLogService operateLogService;*/
    /**
     * @Description: 获取HttpServletRequest
     * @return
     *
     * @History 1. 2014-10-16 linwb 创建方法
     */
    protected HttpServletRequest getRequest() {
        RequestAttributes reqAttributes = RequestContextHolder.getRequestAttributes();
        if (reqAttributes == null) {
            logger.error("无法获取RequestAttributes对象");
            return null;
        }

        return ((ServletRequestAttributes) reqAttributes).getRequest();
    }

    /**
     * @Description: 获取当前登录的用户
     * @return
     *
     * @History 1. 2014-10-16 linwb 创建方法
     */
    protected SysUser getCurrentUser() {
        HttpServletRequest req = getRequest();
        if (req == null) {
            logger.error("无法获取HttpServletRequest对象,对象为空");
            return null;
        }

        return (SysUser) req.getSession(false).getAttribute(BaseConstants.CURRENT_USER);
    }

    /**
     * @Description: 获取当前登录用户的名称
     * @return
     *
     * @History 1. 2014-11-6 cailq 创建方法
     */
    protected String getCurrentUserName() {
        SysUser sysUser = getCurrentUser();
        if (sysUser != null) {
            return sysUser.getUsername();
        }
        logger.error("无法获取当前登陆用户的名称，登陆用户为空");
        return null;
    }


    /**
     * @Description: 获取当前登录的用户所在的部门
     * @return
     *
     * @History 1. 2014-10-16 linwb 创建方法
     */
    protected SysDepartment getCurrentDept() {
        HttpServletRequest req = getRequest();
        if (req == null) {
            logger.error("无法获取HttpServletRequest对象,对象为空");
            return null;
        }

        return (SysDepartment) req.getSession(false).getAttribute(BaseConstants.CURRENT_DEPT);
    }

}
