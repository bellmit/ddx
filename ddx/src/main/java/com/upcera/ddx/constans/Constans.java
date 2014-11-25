package com.upcera.ddx.constans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.ContextLoader;


public class Constans {
	/**
	 * 
	 * @Description: 用户权限定义
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	//注册专用
	public final static String ROLE_SIGN = "ROLE_SIGN";
	//技工间
	public final static String ROLE_LAB = "ROLE_LAB";
	//诊所
	public final static String ROLE_PRACTICE = "ROLE_PRACTICE";
	
	/**
	 * 
	 * @Description: 案例状态
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	public final static String CASE_STATUS_OPEN = "OPEN";//打开
	public final static String CASE_STATUS_CLOSE = "CLOSE";//关闭
	public final static String CASE_STATUS_CANCEL = "CANCEL";//取消
	
	public final static String CASE_ONHOLD_STATUS_TRYIN = "__TRYIN__";//返回试戴置订单状态
	
	
	/**
	 * 
	 * @Description: 机构代码定义
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	public final static String UNIT_LAB = "1";//技工间
	public final static String UNIT_PRACTICE = "2";//诊所
	
	/**
	 * 
	 * @Description: 申請添加伙伴技工间，审批状态
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	public final static String PLAB_APPROVAL_OK = "0";//审批通过
	public final static String PLAB_APPROVAL_CLOSE = "1";//关闭（拒绝）
	public final static String PLAB_APPROVAL_WAIT = "2";//待审批
	public final static Map<String, String> approvalStatus = new HashMap<String, String>();
	static{
		approvalStatus.put(PLAB_APPROVAL_OK, "激活");
		approvalStatus.put(PLAB_APPROVAL_CLOSE, "关闭");
		approvalStatus.put(PLAB_APPROVAL_WAIT, "取消");
	}
	
	
	
	/**
	 * 
	 * @Description: 工序属性可选标识定义
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	public final static String PRESENCE_REQUIRED= "REQUIRED";//需要
	public final static String PRESENCE_OPTIONAL = "OPTIONAL";//可选
	public final static String PRESENCE_NOT_APPLICABLE = "NOT_APPLICABLE";//不适用

	/**
	 * 
	 * @Description: 静态数据配置 key-value
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	public final static String CACHE_NAME_KEY = "key";
	public final static String CACHE_NAME_VALUE = "value";
	
	//文件下载统一存放路径
	public final static String FILE_DOWNLAOD_PATH = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/")+"temp/";
	
	
	/**
	 * 订单过滤条件
	 */
	public final static String CASES_FILTER_BYMONTH = "byMonth";
	public final static String CASES_FILTER_TOARRIVE = "toArrive";
	public final static String CASES_FILTER_TOSHIP = "toShip";
	public final static String CASES_FILTER_OPENTRYINS = "openTryIns";
	public final static String CASES_FILTER_ONHOLD = "onHold";
	public final static String CASES_FILTER_TOOUTSOURCE = "toOutsource";
	
	/**
	 * 订单创建方式
	 */
	public final static String CASES_NEWTYPE_ADD = "add";
	public final static String CASES_NEWTYPE_RESUME = "resume";
	public final static String CASES_NEWTYPE_BASE_PATIENT = "basePatient";
	public final static String CASES_NEWTYPE_OUTSOURCE = "outsource";
	public final static String CASES_NEWTYPE_REMAKE = "remake";
	
	
	public final static Map<String, String> casesNewType = new HashMap<String, String>();
	static{
		casesNewType.put(CASES_NEWTYPE_ADD, "新建订单");
		casesNewType.put(CASES_NEWTYPE_RESUME, "新建订单草稿");
		casesNewType.put(CASES_NEWTYPE_BASE_PATIENT, "通过旧病例新建订单");
		casesNewType.put(CASES_NEWTYPE_OUTSOURCE, "新建外包订单");
		casesNewType.put(CASES_NEWTYPE_REMAKE, "重制订单");
	}
	/**
	 * 工序特征-类型字段定义
	 */
	public final static String PROCEDURES_CHARACTERIS_MATERIALS = "materials";//材料
	public final static String PROCEDURES_CHARACTERIS_ENCLOSURES = "enclosures";//附件
	public final static String PROCEDURES_CHARACTERIS_ACRYLICCOLORS = "acrylicColors";//亚克力色
	public final static String PROCEDURES_CHARACTERIS_SPORTGUARDCOLORS = "sportGuardColors";//运动防护色
	public final static String PROCEDURES_CHARACTERIS_ORTHODONTICCOLORS = "orthodonticColors";//正畸色
	public final static String PROCEDURES_CHARACTERIS_ORTHODONTICDESIGNS = "orthodonticDesigns";//正畸设计
	public final static String PROCEDURES_CHARACTERIS_IMPLANTSYSTEMS = "implantSystems";//种植系统
	public final static String PROCEDURES_CHARACTERIS_IMPLANTMARKERS = "implantMarkers";//种植制作
	
	/**
	 * 验证码错误
	 */
	public final static String ERROR_VERIFY_CODE = "error_verify_code";
	
	/**
	 * 重复的邮箱
	 */
	public final static String DUPLICATE_EMAIL = "duplicate_email";
	
	
	/**
	 * 记住用户名和密码功能
	 */
	//保存用户名和密码 cookie name
	public final static String MEMORY_USER_NAME = "Memory_User_Name";
	//保存用户名和密码 cookie password
	public final static String MEMORY_USER_PASSWORD = "Memory_User_Password";
	//保存用户名和密码 cookie fate
	public final static String MEMORY_USER_FATES = "Memory_User_fate";
	
	/**
	 * 计数单位
	 */
	public final static String COUNT_UNIT_TEETH = "1";//按牙齿
	public final static String COUNT_UNIT_ARCH = "2";//按拱门
	/**
	 * 牙位标记方式
	 */
	public final static String TEETH_NOTATION_FDI = "1";//FDI标记
	public final static String TEETH_NOTATION_UNIVERSAL = "2";//普通标记
	
	/**
	 * 优惠券类型
	 */
	public final static String COUPONS_TYPE_SINGLE = "S";//单次使用
	public final static String COUPONS_TYPE_MULTI = "M";//多次使用
	/**
	 * 优惠券折扣类型
	 */
	public final static String COUPONS_DISCOUNT_TYPE_PERCENTAGE = "P";//百分比
	public final static String COUPONS_DISCOUNT_TYPE_FIXED_MONITARY = "F";//固定金额
	
	/**
	 * 议价审批状态
	 */
	public final static String CASES_BARGAIN_VERIFY_AGREE = "1";
	public final static String CASES_BARGAIN_VERIFY_DISAGREE = "0";
	
	/**
	 * 开放接口的数据返回方式
	 */
	public final static String OPEN_API_RETURN_TYPE_STRING = "string";
	public final static String OPEN_API_RETURN_TYPE_STREAM = "stream";
}
