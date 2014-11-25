/**   
 * @Title: KaptchaImageCreateController.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-20 下午03:26:04 
 * @version V1.0   
 */
package com.upcera.ddx.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Producer;
import com.upcera.ddx.common.GlobalConstants;

/**
 * @ClassName: KaptchaImageCreateController
 * @Description: Kaptcha生成验证码
 * @author ERIC
 * @date 2014-6-20 下午03:26:04
 * 
 */
@Controller
@RequestMapping("/kaptchaAction")
public class KaptchaImageCreateController {

	private Producer captchaProducer = null;

	@Autowired
	public void setKaptchaProducer(Producer captchaProducer) {
		this.captchaProducer = captchaProducer;
	}

	@RequestMapping(value = "/getVerify")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(GlobalConstants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = "/chkVerify")
	public void chkVerify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String vcode = request.getParameter("verifyCode").toLowerCase();
			String realCode = ((String) request.getSession().getAttribute(GlobalConstants.KAPTCHA_SESSION_KEY)).toLowerCase();
			String flagStr = "false";
			if (vcode.equals(realCode)) {
				flagStr = "true";
			}
			BaseAction.outReturnString(flagStr, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
