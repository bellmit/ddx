package com.upcera.ddx.open.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.upcera.ddx.action.BaseAction;
import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.security.CtyptoUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.common.util.ToolsKit.DateUtil;
import com.upcera.ddx.common.util.ToolsKit.EmptyCheckUtil;
import com.upcera.ddx.common.util.ToolsKit.FileUtil;
import com.upcera.ddx.common.util.ToolsKit.TypeConversionUtil;
import com.upcera.ddx.common.util.ToolsKit.jsonUitl;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.open.pojo.ErrorInfo;
import com.upcera.ddx.open.pojo.Request;
import com.upcera.ddx.open.pojo.Response;
import com.upcera.ddx.service.user.IUserService;

@Controller
@RequestMapping("/open")
public class OpenSerice extends BaseAction {

	@Autowired
	private BaseCache baseCache;
	@Autowired
	private IUserService userService;
	
	private static int MAX_CONTEXT_LENHTH = 64 * 1024;

	public static Map<String, Map<String, Object>> session_context = new HashMap<String, Map<String, Object>>();

	public static User getSessionUser(String token) {
		try {
			return (User) session_context.get(token).get("user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	private final Logger logger = LoggerFactory.getLogger(OpenSerice.class);

	/**
	 * 
	 * @Title: serice
	 * @Description: 开放接口
	 * @author king
	 * @date 2014-7-21下午03:10:47
	 * @return void
	 */
	@RequestMapping("/service")
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		setRegistrationRole();
		Response result = new Response();
		ErrorInfo error = new ErrorInfo();
		String method = request.getMethod();
		if ("GET".equals(method)) {
			error.setCode("403");
			error.setMessage("服务器拒绝GET请求！");
			result.setErrorInfo(error);
			responseHttp(result, response);
			return;
		}

		// 读取报文
		String inPackage = "";
		try {
			inPackage = getContext(request);
		} catch (Exception e) {
			error.setCode("-2");
			error.setMessage(e.getMessage());
			result.setErrorInfo(error);
			responseHttp(result, response);
			return;
		}
		logger.error("输入报文：" + inPackage);

		Request requestInPackage = null;
		try {
			requestInPackage = jsonUitl.toBean(Request.class, inPackage);
		} catch (Exception e1) {
			error.setCode("-2");
			error.setMessage("请求报文格式错误！");
			result.setErrorInfo(error);
			responseHttp(result, response);
			return;
		}
		// 校验
		String token = checking(requestInPackage);
		if (EmptyCheckUtil.isEmpty(token)) {
			error.setCode("-3");
			error.setMessage("无效的口令或用户名及密码！");
			result.setErrorInfo(error);
			responseHttp(result, response);
			return;
		}
		// 获取业务编码
		String busiCode = requestInPackage.getPublicInfo().getBusiCode();
		if (EmptyCheckUtil.isEmpty(busiCode)) {
			error.setCode("-4");
			error.setMessage("未指业务编码，系统无法处理！");
			result.setErrorInfo(error);
			responseHttp(result, response);
			return;
		}
		// 业务处理
		try {
			String classz = String.valueOf(baseCache.getApiUrl().get(busiCode));
			if(classz==null){
				error.setCode("404");
				error.setMessage("处理失败，未找到业务定义："+busiCode);
				result.setErrorInfo(error);
				responseHttp(result, response);
				return;
			}

			Object retObj = null;
			try {
				WebApplicationContext con = ContextLoader.getCurrentWebApplicationContext();
				Object obj = con.getBean(Class.forName(classz));
				
				Method met = Class.forName(classz).getMethod(busiCode, Request.class);
				retObj = met.invoke(obj, requestInPackage);
			} catch (Exception e) {
				error.setCode("500");
				error.setMessage("系统内部错误:"+e.getMessage());
				result.setErrorInfo(error);
				responseHttp(result, response);
				return;
			}
			
			String retType = requestInPackage.getPublicInfo().getRetType();
			if(ToolsKit.EmptyCheckUtil.isEmpty(retType) || Constans.OPEN_API_RETURN_TYPE_STRING.equals(retType)){
				error.setCode("0");
				error.setMessage("成功");
				
				result.setErrorInfo(error);
				result.setRetInfo(retObj);
				responseHttp(result, response);
				return;
			}
			
			if(Constans.OPEN_API_RETURN_TYPE_STREAM.equals(retType)){
				responseHttpStream(retObj, response);
			}
			
		} catch (Exception e) {
			error.setCode("-5");
			error.setMessage("系统异常，处理失败:" + e.getMessage());
			result.setErrorInfo(error);
			responseHttp(result, response);
		}
	}
	
	private void responseHttp(Response result,HttpServletResponse response){
		try {
			String json = jsonUitl.toJson(result);
			outReturnString(json, response);
			logger.error("输出报文：" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getPath(){
		return Constans.FILE_DOWNLAOD_PATH + DateUtil.ssss()+".txt";
	}
	
	private void createFile(Object obj,File file) throws Exception{
		Response result = new Response();
		ErrorInfo error = new ErrorInfo();
		error.setCode("0");
		error.setMessage("成功");
		result.setErrorInfo(error);
		result.setRetInfo(obj);
		String path = getPath();
		file = new File(path);
		FileUtil.writeFile(path, jsonUitl.toJson(result), true);
	}
	/**
	 * 响应流
	 * 
	 * @throws Exception
	 */
	private void responseHttpStream(Object obj,HttpServletResponse response) {
		
		File file = null;
		if(obj instanceof File){
			file = (File)obj;
		}
		if(file == null){
			try {
				createFile(obj, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (file==null || !file.exists()) {
			logger.error("文件下载失败：文件或路径错误");
			return;
		}
		long fileLength = file.length();
		response.setContentType("application/octet-stream");
		response.setHeader("Content_Length", String.valueOf(fileLength));
		response.setHeader("Content-disposition", "attachment;filename=" + file.getName());
		
		FileInputStream input = null;
		ServletOutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = response.getOutputStream();
			byte[] block = new byte[1024];
			int len = 0;
			while ((len = input.read(block)) != -1) {
				output.write(block, 0, len);
			}
			output.flush();
			return;
		} catch (IOException e) {
			logger.error("文件下载失败：" + e.getMessage());
			return;
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			} catch (IOException ex) {
				logger.error(ex.getMessage());
			}
		}
	}
	
	/**
	 * 校验口令或用户密码
	 * 
	 * @throws Exception
	 */
	private String checking(Request inPackage) throws Exception {
		Map<String, Object> context = session_context.get(inPackage.getPublicInfo().getToken());
		if (null != context) {
			Date failure = (Date) context.get("failure");
			if (failure.getTime() > DateUtil.nowDate().getTime()) {
				// 未实效
				return inPackage.getPublicInfo().getToken();
			}else{
				session_context.remove(inPackage.getPublicInfo().getToken());
				throw new Exception("会话已过期，请重新登录！");
			}
		}
		//登陆
		if("login".equals(inPackage.getPublicInfo().getBusiCode())){
			String acctId = TypeConversionUtil.asString(inPackage.getParameter().get("acctId"));
			String unitType =  TypeConversionUtil.asString(inPackage.getParameter().get("unitType"));
			String acctPassword =  TypeConversionUtil.asString(inPackage.getParameter().get("acctPassword"));
			if (EmptyCheckUtil.isNotEmpty(acctId) && EmptyCheckUtil.isNotEmpty(acctPassword) && EmptyCheckUtil.isNotEmpty(unitType)) {
				User user = new User();
				user.setEmail(acctId);
				user.setUnitType(unitType);
				user.setPassword(CtyptoUtil.EncryptString(acctPassword));
				List<User> listUser = userService.listAllByEqual(user, 0, 0);
				if (listUser != null && listUser.size() == 1) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("user", listUser.get(0));
					map.put("failure", DateUtil.addHours(DateUtil.nowDate(), 1));
					String tokenId = UUID.randomUUID().toString();
					session_context.put(tokenId, map);
					inPackage.getPublicInfo().setToken(tokenId);
					return tokenId;
				}
			}
		}
		return null;
	}

	/**
	 * 获取二进制的报文体，并转换成字符串
	 * 
	 * @throws Exception
	 */
	private String getContext(HttpServletRequest request) throws Exception {
		byte[] buffer = new byte[MAX_CONTEXT_LENHTH];

		InputStream in = request.getInputStream();
		int length = in.read(buffer);
		if (length <= 0) {
			throw new Exception("请求报文为空，系统无法处理！");
		}
		String encode = request.getCharacterEncoding();
		if (EmptyCheckUtil.isEmpty(encode)) {
			throw new Exception("未指明字符集编码，系统无法处理！");
		}
		byte[] data = new byte[length];
		System.arraycopy(buffer, 0, data, 0, length);
		String context = new String(data, encode);

		return context;
	}
}
