package com.ylzinfo.bigdata.utils;

import com.google.common.base.CaseFormat;
import com.ylzinfo.bigdata.constants.BaseConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;
import static org.apache.commons.lang3.StringUtils.substringBeforeLast;

/**
 * 
 * String相关工具类
 *
 * @since chenran, 2017年7月12日, 创建文件
 */
public class StringUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
    // 高亮标识
    private static final Pattern HTML_REG_LT = Pattern.compile("<");
    private static final Pattern HTML_REG_GT = Pattern.compile(">");
    private static final Pattern HTML_REG_QUOT = Pattern.compile("\"");
	
    // 判断字符串是否为合法的GUID
    public static final Pattern GUID_PATTERN = Pattern.compile("[0-9a-fA-F]{32}");
    // 判断是否为合法的HEX
    public static final Pattern IS_HEX = Pattern.compile("[a-fA-F]+");
    // 判断是否为合法的手机号码
    public static final String TELEPHONE_REGEX = "^1[3|5|7|8]\\d{9}$";
    // 判断字符串是否都为中文
    public static final Pattern IS_CHINESE = Pattern.compile("[\u4e00-\u9fa5]+");
    // 判断字符串是否由数字和字母组成
    public static final Pattern CHAR_OR_NUMERIC = Pattern.compile("^[A-Za-z0-9]+$");
    // 判断字符串是否由字母组成
    public static final Pattern IS_CHAR = Pattern.compile("^[A-Za-z]+$");
    
    
    /**
     * 获取md5处理后的base64编码ID
     * @return
     * @since chenran, 2017年3月3日, 新增方法
     */
    public static String getBase64Guid() {
        return Base64.encodeBase64URLSafeString(DigestUtils.md5(getFormatGuid()));
    }
    
    /**
     * 获取md5处理后的base64编码ID
     * @param str 待md5处理的字符串
     * @return
     * @since chenran, 2017年3月3日, 新增方法
     */
    public static String getBase64Guid(String str) {
        return Base64.encodeBase64URLSafeString(DigestUtils.md5(str));
    }
    
    /**
     * 获取处理后的base64编码ID
     * @param bytes 待处理的字节数组
     * @return
     * @since chenran, 2017年3月3日, 新增方法
     */
    public static String getBase64Guid(byte[] bytes) {
        return Base64.encodeBase64URLSafeString(bytes);
    }
    
    /**
     * 获取随机GUID
     *
     * @return 32位GUID，不带"-"
     * @since chenran, 2016-12-05, 创建方法
     */
    public static String getFormatGuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    /**
     * 去除左边的0
     *
     * @param str 字符串
     * @since chenran, 2015-2-10, 创建方法
     */
    public static String removeZero(String str) {
        return str.replaceFirst("^0*", "");
    }

    /**
     * 数字字符串转化为整数
     *
     * @param srcStr       String 待转化的数字字符串
     * @param defaultValue int 当srcStr为null,空字符串,或者不能转换为数字时返回的缺省值
     * @return int 返回由数字字符串转化成的数字，当srcStr为空或空字符串时，返回缺省值defaultValue
     */
    public static int getInt(String srcStr, int defaultValue) {
        if (StringUtils.isEmpty(srcStr))
            return defaultValue;
        int result = defaultValue;
        try {
            Double db = new Double(srcStr);
            result = db.intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断字符串是否由数字和字母组成
     *
     * @param text 待判断的字符串
     * @return true--是  false--否
     * @since chenran, 2014-12-11, 创建方法
     */
    public static boolean isCharOrNumeric(String text) {
        Matcher match = CHAR_OR_NUMERIC.matcher(text);
        return match.find();
    }

    /**
     * 判断字符串是否由字母组成
     *
     * @param text 待判断的字符串
     * @return true--是  false--否
     * @since chenran, 2014-12-11, 创建方法
     */
    public static boolean isChar(String text) {
        Matcher match = IS_CHAR.matcher(text);
        return match.find();
    }

    /**
     * 第一个字符大写(效率较高)
     *
     * @param fieldName 字符串
     * @return 第1个字符转大写后的字符串
     * @since chenran, 2014-7-14, 创建方法
     */
    public static String upperFirstCharName(String fieldName) {
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    /**
     * 第一个字符小写(效率较高)
     *
     * @param fieldName 字符串
     * @return 第1个字符转小写后的字符串
     * @since chenran, 2014-7-14, 创建方法
     */
    public static String lowerFirstCharName(String fieldName) {
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'A' + 'a');
        return new String(items);
    }

    /**
     * 获得非空字符串
     *
     * @param str 任何对象
     * @return 非空字符串
     */
    public static String toNoNullStr(Object str) {
        return str == null ? "" : str.toString();
    }

    /**
     * 获得非空整数
     * @param str
     * @return
     * @since chenran, 2017年7月12日, 新增方法
     */
    public static Integer toNoNullInt(Object str){
    	if(str instanceof Integer){
    		return Integer.parseInt(str.toString());
    	}else{
    		return null;
    	}
    }
    
    /**
     * HTML转义字符编码(空格和邮箱符号不转)
     *
     * @param str 待转义的字符串
     * @return 转义后的字符串
     */
    public static String htmlEncodeForSolr(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return htmlDecodeForSolr(str).replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\'", "&apos;").replaceAll("\"", "&quot;");
    }

    /**
     * 转义HTML字符编码(空格和邮箱符号不转)
     *
     * @param str 待转义的字符串
     * @return 转义后的字符串
     */
    public static String htmlDecodeForSolr(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">")
                .replaceAll("&apos;", "\'").replaceAll("&quot;", "\"");
    }

    /**
     * 普通字符串转化为网页中可显示的，如回车转化为&lt;br&gt;.
     *
     * @param str String 待转化的字符串
     * @return String 转化后的字符串
     */
    public static String htmlEncode(String str) {
        String retu;
        if (null == str || "".equals(str.trim())) {
            retu = str;
        } else {
            String html = str;
            html = StringUtils.replace(html, "&", "&amp;");
            html = StringUtils.replace(html, "<", "&lt;");
            html = StringUtils.replace(html, ">", "&gt;");
            html = StringUtils.replace(html, "\r\n", "\n");
            html = StringUtils.replace(html, "\n", "<br>");
            html = StringUtils.replace(html, "\t", "    ");
            html = StringUtils.replace(html, " ", "&nbsp;");
            html = StringUtils.replace(html, "\"", "&quot;");
            html = StringUtils.replace(html, "\'", "&apos;");
            retu = html;
        }
        return retu;
    }
    

    /**
     * 过滤掉字符串中的乱码
     * @param src
     * @return
     * @since chenran, 2017年7月12日, 新增方法
     */
    public static String filterUtf8(String src){
        String regex = "[^\\u0000-\\uffff]";//非UTF-8编码
        if(!StringUtils.isBlank(src)){
            return src.replaceAll(regex, "");
        }else{
            return src;
        }
    }
    
    /**
     * 字符串URL解码
     * @param str
     * @return
     * @since chenran, 2017年7月12日, 新增方法
     */
    public static String decode(String str) {
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            logger.warn("字符串:{}，解码失败！", str, e);
        }
        return str;
    }
    
    /**
     * 将驼峰命名风格的字符串转换成以下划线隔开的大写字符串<br/>
     *               exp : spiderCommon -> SPIDER_COMMON
     * @param str
     * @return
     * @since chenran, 2017年7月12日, 新增方法
     */
    public static String toUpper(String str) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
    }
    
    /**
     * 将以下划线隔开的大写字符串转换成驼峰命名风格的字符串<br/>
     *               exp : SPIDER_COMMON -> spiderCommon
     * @param str
     * @return
     * @since chenran, 2017年7月12日, 新增方法
     */
    public static String toLower(String str) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }
    
    /**
     * 处理特殊字符查询( 包含%_{}\)
     * @param inputVal 输入的字符串
     * @return 转义后的字符串
     *
     * @since chenran, 2017年7月12日, 新增方法
     */
    public static String escapeSql(String inputVal) {
        if (StringUtils.isBlank(inputVal)) { 
        	return inputVal;
        }
        inputVal = StringUtils.replace(inputVal, "%", "\\%");
        inputVal = StringUtils.replace(inputVal, "_", "\\_");
        inputVal = StringUtils.replace(inputVal, "{", "\\{");
        inputVal = StringUtils.replace(inputVal, "}", "\\}");
        inputVal = StringUtils.replace(inputVal, "\\", "\\\\");
        return inputVal;
    }
    
    /**
     * 攫取单位编码的方法，到达0之前攫取，并补充到符合的位数
     * 
     * @param pcsCode
     * @return
     */
    public static String snatchPcsCode(String pcsCode) {
        char[] character = pcsCode.toCharArray();
        for (int i = character.length - 1; i > 0; i--) {
            if (!Character.valueOf('0').equals(Character.valueOf(character[i]))) {
                pcsCode = pcsCode.substring(0, i + 1);
                break;
            }
        }
        if (!"".equals(pcsCode) && (pcsCode.length() % 2 != 0)) {
            pcsCode += "0";
        }
        return pcsCode;
    }
    
    /**
     * 校验手机号码格式是否正确
     * @param telephone 传入的手机号码不能为空
     * @return
     * @since chenran, 2017年3月22日, 新增方法
     */
    public static Boolean checkMobile(String telephone) {
		if (telephone.matches(TELEPHONE_REGEX)) {
			return true;
		}
        return false;
    }
    
    /**
     * @Description: 字符URL编码
     * @param str
     * @return
     *
     * @since chenran, 2017年3月22日, 新增方法
     */
    public static String encode(String str) {
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            logger.warn("字符串:{}，编码失败！", str, e);
        }
        return str;
    }
    
    /**
     * @Description: 获取拆分后的集合
     * @param sources 源字符串(以‘,’分隔)
     * @since chenran, 2017年3月22日, 新增方法
     */
    public static List<String> splitToList(String sources) {
        if(StringUtils.isEmpty(sources)){
            return new ArrayList<String>();
        }else{
            return Arrays.asList(sources.split(","));
        }
    }
    
    /**
     * 通过分割，获取IP值
     * @param url 比如：172.16.2.184:3181,172.16.2.200:3181,172.16.2.201:3181*
     * @return 172.16.2.184:3181,172.16.2.200:3181,172.16.2.201
     * @since chenran, 2017年5月3日, 新增方法
     */
    public static String splitToHost(String url){
        if(StringUtils.isBlank(url)){
            return null;
        }
        List<String> hosts = new ArrayList<String>();
        for (String node : split(url, BaseConstants.COMMA)) {
            String hostName = substringBeforeLast(node, BaseConstants.COLON);
            hosts.add(hostName);
        }
        return StringUtils.join(hosts,BaseConstants.COMMA);
    }
    
    /**
     * 通过分割，获取端口号
     * @param url 比如：172.16.2.184:3181,172.16.2.200:3181,172.16.2.201:3181*
     * @return 3181
     * @since chenran, 2017年5月3日, 新增方法
     */
    public static String splitToPort(String url){
        if(StringUtils.isBlank(url)){
            return null;
        }
        String port = null;
        for (String node : split(url, BaseConstants.COMMA)) {
            port = substringAfterLast(node, BaseConstants.COLON);
            break;
        }
        return port;
    }
}
