package com.upcera.ddx.action;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.GlobalConstants;
import com.upcera.ddx.common.Response;
import com.upcera.ddx.common.StatusCode;
import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.mail.MailSenderService;
import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.security.CtyptoUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.ResetPassword;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.ILabSignUpDirectSoundService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.IResetPasswordService;
import com.upcera.ddx.service.user.IUserService;

/**
 * 用户管理 demo
 * 
 * @author 金德志
 * 
 */
@Controller
@RequestMapping("/userAction")
public class UserAction extends BaseAction {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ILabService labService;
	@Autowired
	private BaseCache baseCache;
	
	@Autowired
	private IPracticeService practiceService;
	
	@Autowired
	private MailSenderService mailSenderService;
	@Autowired
	private IResetPasswordService resetPasswordService;
	/**
	 * 
	 * @Title: login 
	 * @Description: 登陆前用户校验，非主用户不能直接登录，登录由spring容器管理
	 * @author king 
	 * @date 2014-6-24 10:33:22 
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/checkUser")
	public void checkUser(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		setRegistrationRole();
		AjaxResult result = new AjaxResult(Booleans.FALSE, "用户名或密码错误");
		String fate = req.getParameter("fate");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String securityType = req.getParameter("securityType");
		
		//校验用户是否存在 以及 是否与技工间和诊所存在关系
		User iuser = null;
		User query = new User();
		query.setEmail(username);
		query.setPassword(CtyptoUtil.EncryptString(password));
		List<User> list = userService.listAllByEqual(query, 0, 0);
		
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(list)){
			iuser = list.get(0);
			if(Constans.UNIT_LAB.equals(fate) && ToolsKit.EmptyCheckUtil.isNotEmpty(iuser.getLabId())){
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(labService.get(iuser.getLabId()))){
					result.setResult(Booleans.TRUE);
				}
			}else if(Constans.UNIT_PRACTICE.equals(fate) && ToolsKit.EmptyCheckUtil.isNotEmpty(iuser.getPracticeId())){
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(practiceService.get(iuser.getPracticeId()))){
					result.setResult(Booleans.TRUE);
				}
			}
		}
		
		//校验用户是否为主用户
		if(result.getResult().equals(Booleans.TRUE)){
			if(iuser.getParentId()!=null && userService.get(iuser.getParentId())!=null){
				result.setResult(Booleans.FALSE);
				result.setFailReasons("对不起，此账户已被其他账户绑定，请用主账户进行登录");
			}
		}
		//保存cookie
		if(result.getResult().equals(Booleans.TRUE) && "private".equals(securityType)){
			Cookie userName=new Cookie(Constans.MEMORY_USER_NAME, username); 
			userName.setMaxAge(365*24*60*60);
			Cookie passw=new Cookie(Constans.MEMORY_USER_PASSWORD, password); 
			passw.setMaxAge(365*24*60*60); 
			Cookie fates=new Cookie(Constans.MEMORY_USER_FATES, fate); 
			fates.setMaxAge(365*24*60*60); 
			resp.addCookie(userName);
			resp.addCookie(passw);
			resp.addCookie(fates);
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登陆页面
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String errorMsg = "";
		String error = req.getParameter("error");
		if ("sessionOut".equals(error)) {
			errorMsg = "会话过期，请重新登录";
		}
		return new MyModelAndView().setViewName("login_lab/login_lab").addObject("errorMessage", errorMsg);
	}

	/**
	 * 
	 * @Title: getUser 
	 * @Description: 根据id查询用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/getUser")
	public ModelAndView getUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer userId = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("userId"));
		User user = userService.get(userId);
		User.DDXActivityLog log = null;
		try {
			log = ToolsKit.jsonUitl.toBean(User.DDXActivityLog.class, user.getDdxActivityLog());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return new MyModelAndView()
					.setViewName("u_lab/u_lab_Settings_UserAccounts_Edit")
					.addObject("MyUser",user)
					.addObject("password", CtyptoUtil.DecryptString(user.getPassword()))
					.addObject("sessionUser", getSessionUserByLoginEmail())
					.addObject("LogSetting", log);
	}
	
	/**
	 * 
	 * @Title: signUp 
	 * @Description: 注册(技工间)
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	@RequestMapping("/signUp")   
	public void signUp(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//service层做了权限控制，注册时未登录必须调用以下方法初始化注册角色
		setRegistrationRole();
		AjaxResult result = new AjaxResult(Booleans.FALSE, "注册失败");
		
		String email = ToolsKit.TypeConversionUtil.asString(req.getParameter("email"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(email)){
			User user = new User();
			user.setEmail(email);
			List<User> userList = userService.listAllByEqual(user, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(userList) && userList.size()>0 ){
				result.setFailReasons(Constans.DUPLICATE_EMAIL);
				outReturnAjaxResult(result, resp);
				return;
			}
		}
		//注册码验证
		String vcode = req.getParameter("verifyCode").toLowerCase();
		String realCode = ((String) req.getSession().getAttribute(GlobalConstants.KAPTCHA_SESSION_KEY)).toLowerCase();
		if (!vcode.equals(realCode)) {
			result.setFailReasons(Constans.ERROR_VERIFY_CODE);
			outReturnAjaxResult(result, resp);
			return;
		}
		
		User user = new User();
		DXObject.setValue(user, req);
		user.setPassword(CtyptoUtil.EncryptString(req.getParameter("password")));
		user.setIsMain("true");
		user.setUnitType(Constans.UNIT_LAB);

		Lab lab = new Lab();
		DXObject.setValue(lab, req);
		lab.setEmail(req.getParameter("labEmail"));
		
		labService.addUserAndLab(user, lab);
	//	labSignUpDirectSoundService.addinitialize();
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	
	@RequestMapping("/signUpForPractice")
	public void signUpForPractice(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//service层做了权限控制，注册时未登录必须调用以下方法初始化注册角色
		setRegistrationRole();
		AjaxResult result = new AjaxResult(Booleans.FALSE, "注册失败");
		String email = ToolsKit.TypeConversionUtil.asString(req.getParameter("email"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(email)){
			User user = new User();
			user.setEmail(email);
			List<User> userList = userService.listAllByEqual(user, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(userList) && userList.size()>0 ){
				result.setFailReasons(Constans.DUPLICATE_EMAIL);
				outReturnAjaxResult(result, resp);
				return;
			}
		}
		//注册码验证
		String vcode = req.getParameter("verificationCode").toLowerCase();
		String realCode = ((String) req.getSession().getAttribute(GlobalConstants.KAPTCHA_SESSION_KEY)).toLowerCase();
		if (!vcode.equals(realCode)) {
			result.setFailReasons(Constans.ERROR_VERIFY_CODE);
			outReturnAjaxResult(result, resp);
			return;
		}
		User user = new User();
		DXObject.setValue(user, req);
		user.setPassword(CtyptoUtil.EncryptString(req.getParameter("password")));
		user.setIsMain("true");
		user.setUnitType(Constans.UNIT_LAB);

		Practice practice = new Practice();
		DXObject.setValue(practice, req);
		practice.setEmail(req.getParameter("practice_email"));
		Response res = practiceService.addData(user, practice);
		if (res.getStatusCode() == StatusCode.SUCCESS) {
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}
	
	
	/**
	 * 
	 * @Title: addUserGroup 
	 * @Description: 增加我的组内用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 * @throws Exception 
	 * @throws Exception 
	 */
	@RequestMapping("/addUserGroup")
	public void addUserGroup(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "用户名或密码错误");
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String role = req.getParameter("role");
			
			//校验用户是否存在
			User user = new User();
			user.setEmail(email);
			user.setPassword(CtyptoUtil.EncryptString(password));
			List<User> list = userService.listAllByEqual(user, 0, 0);
			
			User iUser = null;
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(list) && list.size() > 0) {
				iUser = list.get(0);
				if (Constans.UNIT_LAB.equals(role)) {
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(iUser.getLabId())) {
						result.setResult(Booleans.TRUE);
					}
				} else {
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(iUser.getPracticeId())) {
						result.setResult(Booleans.TRUE);
					}
				}
			}
			//添加至组
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(iUser) && result.getResult().equals(Booleans.TRUE)){
				Integer sessionUserId = getSessionUserByLoginEmail().getAccountId();
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(iUser.getParentId()) && ToolsKit.EmptyCheckUtil.isNotEmpty(userService.get(iUser.getParentId()))){
					if(iUser.getParentId().equals(sessionUserId)){
						result.setResult(Booleans.FALSE);
						result.setFailReasons("该用户已是您的组内用户，无需重复添加");
					}else{
						result.setResult(Booleans.FALSE);
						result.setFailReasons("该用户已在一个组内");
					}
				}else{
					User query = new User();
					query.setParentId(iUser.getAccountId());
					List<User> sonList = userService.listAllByEqual(query, 0, 0);
					if(ToolsKit.EmptyCheckUtil.isNotEmpty(sonList)){
						result.setResult(Booleans.FALSE);
						result.setFailReasons("该用户已在一个组内为主用户");
					}
				}
				if(result.getResult().equals(Booleans.TRUE)){
					iUser.setParentId(getSessionUserByLoginEmail().getAccountId());
					userService.update(iUser);
				}
				
			}
		} catch (Exception e) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: sendResPasswordMail 
	 * @Description: 检查用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 * @throws Exception 
	 * @throws Exception 
	 */
	@RequestMapping("/checkReset")
	public void checkReset(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		setRegistrationRole();
		AjaxResult result = new AjaxResult(Booleans.FALSE, "用户不存在");
		try {
			String fate = req.getParameter("selectItems");
			String username = req.getParameter("email");
			String pw = req.getParameter("newPassword");
			User iuser = null;
			User query = new User();
			query.setEmail(username);
			List<User> list = userService.listAllByEqual(query, 0, 0);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(list)) {
				iuser = list.get(0);
				if (Constans.UNIT_LAB.equals(fate) && ToolsKit.EmptyCheckUtil.isNotEmpty(iuser.getLabId())) {
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(labService.get(iuser.getLabId()))) {
						result.setResult(Booleans.TRUE);
					}
				} else if (Constans.UNIT_PRACTICE.equals(fate) && ToolsKit.EmptyCheckUtil.isNotEmpty(iuser.getPracticeId())) {
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(practiceService.get(iuser.getPracticeId()))) {
						result.setResult(Booleans.TRUE);
					}
				}
				if (result.getResult().equals(Booleans.TRUE)) {
					ResetPassword rp = new ResetPassword();
					String password = CtyptoUtil.EncryptString(pw);
					Integer resetwhether = 0;
					rp.setResetemail(username);
					rp.setResetpassword(password);
					rp.setResetwhether(resetwhether);
					rp.setResettype(fate);
					rp.setResetwhether(resetwhether);
					resetPasswordService.addOrUpdate(rp);
					String[] recipients = new String[]{username};
					mailSenderService.sendMail(null, "liaoming@upcera.com", recipients, "重置密码", "为DDX账户" + username + "修改一个密码，"
							+ "如果你希望修改你的密码，请点击下面这个链接<a href='" + baseCache.getHttpConfig() + "/ddx/userAction/activate.do?id="
							+ CtyptoUtil.EncryptString(username) + "&pw=" + password + "'>点击激活</a>，如果你不想修改密码请忽略此邮件");
				}

			}
		} catch (Exception e) {
			String error = e.getMessage();
			result.setResult(Booleans.FALSE);
			if(e instanceof MailSendException){
				error = "重置密码失败，无效的邮箱地址";
			}
			result.setFailReasons(error);
			
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: sendResPasswordMail 
	 * @Description: 重置郵箱密碼
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 * @throws Exception 
	 * @throws Exception 
	 */
	//1 用戶郵箱，用戶類型 ，需要更新的密碼，是否已重置（true/false）
	//2 接受一個郵箱和類型
	
	@RequestMapping("/activate")
	public ModelAndView activate(HttpServletRequest req, HttpServletResponse resp) throws NoSuchAlgorithmException, Exception {
		setRegistrationRole();
		ResetPassword rp = new ResetPassword();
		DXObject.setValue(rp, req);
		String us = req.getParameter("id");
		String ps = req.getParameter("pw");
		String username = CtyptoUtil.DecryptString(us);
		rp.setResetemail(username);
		rp.setResetpassword(ps);
		List<ResetPassword> rpdatas = resetPasswordService.listAllByEqual(rp, 0, 0);
		if (rpdatas.size() == 0) {
			return new MyModelAndView().setViewName("login_lab/user_reset_password_error");
		} else {
			rp = rpdatas.get(0);
			Integer resetwhether = rp.getResetwhether();
			if (resetwhether == 1) {
				return new MyModelAndView().setViewName("login_lab/user_reset_password_error");
			} else {
				try {
					User user = new User();
					user.setEmail(username);
					user.setPassword(ps);
					userService.updateUserPassword(user);
					rp.setResetemail(username);
					Integer reset = 1;
					rp.setResetwhether(reset);
					resetPasswordService.updateResetwhether(rp);

				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
				return new MyModelAndView().setViewName("login_lab/user_reset_password_updatesuccess");
			}
		}
	}
	
	/**
	 * 
	 * @Title: isExistEmail 
	 * @Description: 验证email是否已存在
	 * @author ERIC 
	 * @date 2014-9-17下午04:13:40
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/isExistEmail")
	public void isExistEmail(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		setRegistrationRole();
		String email = ToolsKit.TypeConversionUtil.asString(req.getParameter("email"));
		String flag = "false";
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(email)){
			User user = new User();
			user.setEmail(email);
			List<User> userList = userService.listAllByEqual(user, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(userList) && userList.size()>0 ){
				flag = "true";	
			}
		}
		outReturnString(flag, resp);
	}
	
}

