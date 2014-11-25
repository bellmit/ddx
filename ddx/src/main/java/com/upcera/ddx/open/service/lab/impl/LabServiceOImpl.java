/**   
 * @Title: LabServiceOImpl.java 
 * @Package com.upcera.ddx.open.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-11-24 上午11:23:52 
 * @version V1.0   
 */ 
package com.upcera.ddx.open.service.lab.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.open.pojo.Request;
import com.upcera.ddx.open.service.lab.ILabServiceO;
import com.upcera.ddx.open.servlet.OpenSerice;
import com.upcera.ddx.service.practice.IPracticeService;

/** 
 * @ClassName: LabServiceOImpl 
 * @Description: 技工间开发接口
 * @author ERIC
 * @date 2014-11-24 上午11:23:52 
 *  
 */
@Controller
public class LabServiceOImpl implements ILabServiceO {
	
	@Autowired
	private IPracticeService practiceService;

	@Override
	public List<Practice> queryPracticeServicedByLab(Request request) {
		
		User user = (User)OpenSerice.session_context.get(request.getPublicInfo().getToken()).get("user");
		Integer labId = user.getLabId();
		List<Practice> practiceList = practiceService.queryPracticeServiedByLabO(labId);
			
		return practiceList;
	}
	

}
