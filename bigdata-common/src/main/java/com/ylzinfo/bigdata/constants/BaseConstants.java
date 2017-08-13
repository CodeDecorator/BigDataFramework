
package com.ylzinfo.bigdata.constants;

/**
 * 
 * 常量类, 全部字段应是static final
 *
 * @since chenran, 2017年7月12日, 创建文件
 */
public class BaseConstants {

	public static final String AMPERSAND = "&";
	public static final String AMPERSAND_HTML = "&amp;";
	public static final String APOSTROPHE = "'";
	public static final String AT = "@";
	public static final String BACK_SLASH = "\\";
	public static final String BLANK = "";
	public static final String CDATA_OPEN = "<![CDATA[";
	public static final String CDATA_CLOSE = "]]>";
	public static final String CLOSE_BRACKET = "]";
	public static final String CLOSE_CURLY_BRACE = "}";
	public static final String CLOSE_PARENTHESIS = ")";
	public static final String COLON = ":";
	public static final String COLON_ZH = "：";
	public static final String COMMA = ",";
	public static final String COMMAZH = "，";
	public static final String DASH = "-";
	public static final String DOUBLE_SLASH = "//";
	public static final String EQUAL = "=";
	public static final String GREATER_THAN = ">";
	public static final String FORWARD_SLASH = "/";
	public static final String GE = " >= ";
	public static final String LE = " <= ";
	public static final String LESS_THAN = "<";
	public static final String LIKE = "LIKE";
	public static final String MINUS = "-";
	public static final String NBSP = "&nbsp;";
	public static final String NEW_LINE = "\n";
	public static final String SEPARATOR = "\t";
	public static final String SEPARATOR_01 = "\01";
	public static final String BR = "<br/>";
	public static final String NOT_EQUAL = "!=";
	public static final String NULL = "null";
	public static final String OPEN_BRACKET = "[";
	public static final String OPEN_BRACKET_ZH = "【";
	public static final String CLOSE_BRACKET_ZH = "】";
	public static final String OPEN_CURLY_BRACE = "{";
	public static final String OPEN_PARENTHESIS = "(";
	public static final String PERCENT = "%";
	public static final String PERIOD = ".";
	public static final String DOC = "·";// 注意与PERIOD的区别“·.”
	public static final String PIPE = "|";
	public static final String PLUS = "+";
	public static final String POUND = "#";
	public static final String DOLLAR = "$";
	public static final String QUESTION = "?";
	public static final String QUOTE = "\"";
	public static final String RETURN = "\r";
	public static final String RETURN_NEW_LINE = "\r\n";
	public static final String SEMICOLON = ";";
	public static final String SLASH = FORWARD_SLASH;
	public static final String SPACE = " ";
	public static final String START = "^";
	public static final String EXCLAMATION = "!";
	public static final String COMMA_WRAP = "','";
	public static final String AND_QUOT = "&quot;";
	public static final String AND_APOS = "&apos;";
	public static final String AND_LT = "&lt;";
	public static final String AND_GT = "&gt;";
	public static final String HTPP_PROTOCOL = "http://";
	
	/** 全角空格 **/
	public static final String SPACE_FULL = "　";
	public static final String SPACE_HTML = "&nbsp;&nbsp;";
	public static final String STAR = "*";
	public static final String TILDE = "~";
	public static final String UNDERLINE = "_";
	public static final String UTF8 = "UTF-8";
	public static final String APPOSE = "、";
	public static final String WRAP = ",";
	
	/** UTF-8编码 BOM标识 */
	public static final byte[] UTF8_BOM = new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
	public static final String HEX_STRING = "0123456789ABCDEF";

	public static final String ASC = "ASC";
	public static final String DESC = "DESC";

	public static final Integer ZERO = 0;
	public static final Integer ONE = 1;
	public static final Integer TWO = 2;
	public static final Integer THREE = 3;
	public static final Integer FIVE = 5;
	public static final Integer TEN = 10;
	public static final Integer TWENTY = 20;
	public static final Integer THOUSAND = 1000;
	public static final Integer TWO_THOUSAND = 2000;

	public static final String ONE_TRUE = "1";
	public static final String ZERO_FALSE = "0";

	public static final String IDD_CHINA = "+0086";
	public static final String COUNTRY_CHINA_CHN = "中国";

	/** 常用字段 */
	public static final String ID = "ID";
	public static final String UUID = "UUID";
	/** 中文 */
	public static final String LANG_ZH = "zh";
	/** 英文 */
	public static final String LANG_EN = "en";
	/** 半选状态 */
	public static final Integer STATUS_HALFCHECK = 2;
	/** 全选状态 */
	public static final Integer STATUS_FULLCHECK = 1;
	/** 是 */
	public static final String YES_CHAR = "Y";
	/** 否 */
	public static final String NO_CHAR = "N";
	
	/**get*/
    public static final String GET = "get";
    /**set*/
    public static final String SET = "set";
    
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String ORDER_NAME = "orders";
	/** 全部*/
    public static final String ALL = "all";
    /** 包含 操作符 IN */
    public static final String IN = "IN";
    /** 不包含 操作符 NIN */
    public static final String NOT_IN = "NIN";
    /** 错误 */
    public static final String LOG_LEVEL_ERROR = "error";
    /** 警告 */
    public static final String LOG_LEVEL_WARN = "warn";
    /** 信息 */
    public static final String LOG_LEVEL_INFO = "info";
    /** 调试 */
    public static final String LOG_LEVEL_DEBUG = "debug";
	/** zookeeper上分布式锁根节点 */
    public static final String ZK_ROOT_NODE = "/locks";
    /** zookeeper地址 */
    public static final String ZOOKEEPER_URL = "zookeeperUrl";
    /** 连接zookeeper超时 */
	public static final int SESSION_TIMEOUT = 5000;
	public static final String CONNECTED = "CONNECTED";
	/** 存储在hbase */
    public static final Integer STORE_FROM_HBASE = 0;
    
    
    /** 反射类型 **/
    public static final String[] REFLECT_LOWER = { "int", "java.lang.String", "boolean", "char",
            "float", "double", "long", "short", "byte" ,"java.util.Date"};
    public static final String[] REFLECT_UPPER = { "java.lang.Integer", "java.lang.String", "java.lang.Boolean",
            "java.lang.Character", "java.lang.Float", "java.lang.Double",
            "java.lang.Long", "java.lang.Short", "java.lang.Byte" ,"java.util.Date"};
    
    public static final String REFLECT_CLASS_NAME = "className";
    
    public static final String ADMIN="admin";

	/**
	 * 当前登录的用户，保存在session中
	 * 在安全过滤器中会根据session中是否存在这个进行判断是否已经登录
	 */
	public static final String CURRENT_USER = "currentUser";
	/**
	 * 当前登录用户所在的部门
	 */
	public static final String CURRENT_DEPT = "currentDept";
}
