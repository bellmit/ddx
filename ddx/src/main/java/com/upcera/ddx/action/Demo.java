package com.upcera.ddx.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.service.user.IUserService;

/**
 * 用户管理 demo
 * 
 * @author 金德志
 * 
 */
@Controller
@RequestMapping("/demo")
public class Demo extends BaseAction {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/menu")
	public ModelAndView menu(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new MyModelAndView().setViewName("demo/menu");
	}
	
	@RequestMapping("/getUser")
	public ModelAndView getUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		java.util.List<User> list = userService.listAll();
		/***
		 * if ajax Response. Please define the return value is void
		 */
		//outReturnString(ToolsKit.jsonUitl.toJson(list), resp);

		/***
		 * if return page view. Please define the return value is ModelAndView
		 */
		 return new MyModelAndView().setViewName("demo/userList").addObject("list", list);
	}

	@RequestMapping("/deleteUser")
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult res = new AjaxResult(Booleans.FALSE, "操作失败");
		try {
			String[] ids = req.getParameter("ids").split(",");
			if(ToolsKit.EmptyCheckUtil.isEmpty(ids)){
				res.setFailReasons("输入不能为空");
			}else{
				Integer[] id = new Integer[ids.length];
				for (int i = 0; i < ids.length; i++) {
					id[i] = ToolsKit.TypeConversionUtil.asInteger(ids[i]);
				}
				userService.delete(id);
				res.setResult(Booleans.TRUE);
			}
		} catch (Exception e) {
			res.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(res, resp);
	}

	@RequestMapping("/addUser")
	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult res = new AjaxResult(Booleans.FALSE, "操作失败");
		String username = req.getParameter("name");
		User user = new User();
		user.setUserName(username);
		userService.add(user);
		res.setResult(Booleans.TRUE);
		outReturnAjaxResult(res, resp);
	}

	@RequestMapping("/updateUser")
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult res = new AjaxResult(Booleans.FALSE, "操作失败");
		Integer accountId = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
		String username = req.getParameter("name");
		User queryEntity = new User();
		queryEntity.setAccountId(accountId);
		User user = userService.get(accountId);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(user)) {
			user.setUserName(username);
			userService.update(user);
			res.setResult(Booleans.TRUE);
		} else {
			res.setFailReasons("无此记录");
		}
		outReturnAjaxResult(res, resp);
	}

}
