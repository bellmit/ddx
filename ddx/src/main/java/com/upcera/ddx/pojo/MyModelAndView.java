package com.upcera.ddx.pojo;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
/**
 * 返回給頁面的視圖類定義
 * @author 金德志
 *
 */
public class MyModelAndView {
	private ModelAndView modelAndView;

	public MyModelAndView() {
		this.modelAndView = new ModelAndView();
	}

	public ModelAndView setView(View view) {
		modelAndView.setView(view);
		return modelAndView;
	}

	public ModelAndView setViewName(String view) {
		modelAndView.setViewName(view);
		return modelAndView;
	}

	public ModelAndView addObject(Object attributeValues) {
		return modelAndView.addObject(attributeValues);
	}

	public ModelAndView addObject(String attributeName, Object attributeValues) {
		return modelAndView.addObject(attributeName, attributeValues);
	}

}
