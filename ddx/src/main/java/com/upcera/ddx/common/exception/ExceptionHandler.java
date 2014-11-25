package com.upcera.ddx.common.exception;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.action.BaseAction;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;

public class ExceptionHandler implements HandlerExceptionResolver {
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		boolean isReturnView = false;
		try {
			String servletPath = request.getServletPath();
			if (servletPath != null) {
				String methodName = servletPath.substring(servletPath.lastIndexOf("/") + 1, servletPath.indexOf("."));
				Method[] met = handler.getClass().newInstance().getClass().getMethods();
				e: for (int i = 0; i < met.length; i++) {
					if (methodName.equals(met[i].getName()) && met[i].getReturnType().getName().equals(ModelAndView.class.getName())) {
						isReturnView = true;
						break e;
					}
				}
			}
			if (!isReturnView) {
				AjaxResult result = new AjaxResult();
				result.setResult(Booleans.FALSE);
				String errorMessage = ex.getMessage();
				if (ToolsKit.EmptyCheckUtil.isEmpty(errorMessage)) {
					errorMessage = "空指针异常！";
				}
				result.setFailReasons(errorMessage);
				if (ex instanceof DataIntegrityViolationException) {
					try {
						DataIntegrityViolationException dex = (DataIntegrityViolationException) ex;
						ConstraintViolationException cex = (ConstraintViolationException) dex.getCause();
						result.setFailReasons("操作失败，系统属性匹配错误:" + cex.getSQLException().getMessage());
					} catch (Exception e) {
						result.setFailReasons("操作失败，系统属性匹配错误");
					}
				} else if (ex instanceof NullPointerException) {
					result.setFailReasons("空指针异常！");
				}
				BaseAction.outReturnAjaxResult(result, response);
				return null;
			}
			logger.error("############################ Exception begin ##############################");
			ex.printStackTrace();
			logger.error("############################ Exception end ##############################");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ex instanceof NullPointerException) {
			ex = new Exception("空指针异常！");
		}
		return new ModelAndView("exception").addObject("exception", ex);
	}
}
