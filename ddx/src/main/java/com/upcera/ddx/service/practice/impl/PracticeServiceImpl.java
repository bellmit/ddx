/**   
 * @Title: PracticeServiceImpl.java 
 * @Package com.upcera.ddx.service.practice.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:41:03 
 * @version V1.0   
 */
package com.upcera.ddx.service.practice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.common.StatusCode;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.practice.IPracticeDao;
import com.upcera.ddx.dao.user.IUserDao;
import com.upcera.ddx.entity.LabPermissions;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.IUserAuthoritiesService;
import com.upcera.ddx.service.user.IUserService;

/**
 * @ClassName: PracticeServiceImpl
 * @Description: 诊所Service实现类
 * @author ERIC
 * @date 2014-6-11 下午02:41:03
 * 
 */
@Service
public class PracticeServiceImpl extends BaseServiceImpl<Practice, Integer> implements IPracticeService {

	@Resource
	IPracticeDao practiceDao;
	
	@Resource
	IUserDao userDao;
	@Resource
	IUserService userService;
	
	@Autowired
	private IUserAuthoritiesService userAuthoritiesService;

	@Override
	public IBaseDao<Practice, Integer> getDao() {
		return practiceDao;
	}

	/**
	 * 
	 * @Title: addData
	 * @Description: 插入数据
	 * @author ERIC
	 * @date 2014-6-11下午03:13:26
	 * @param @return
	 * @return Response
	 */
	public Response addData(User user, Practice practice) {
		Response res = new Response();
		try {
			practiceDao.add(practice);
			user.setPracticeId(practice.getId());
			user.setUnitType(Constans.UNIT_PRACTICE);
			user.setIsMain("true");
			user.setManagerAccount("true");
			user.setCreateCaseTags("true");
			userDao.add(user);
			//默认设置诊所主治医师
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(user.getAccountId())){
				practice.setProviders(user.getAccountId().toString());
				practiceDao.update(practice);
			}
			
			//用户注册权限
			UserAuthorities ua = new UserAuthorities();
			ua.setUsername(user.getEmail());
			ua.setAuthority(Constans.ROLE_PRACTICE);
			userAuthoritiesService.add(ua);
			
			res.setStatusCode(StatusCode.SUCCESS);
		} catch (Exception e) {
			res.setStatusCode(StatusCode.FAILED);
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的的诊所
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	@Override
	public List<Practice> getRequestAccountPractice(Integer labId,int pageNo,int pageSize,String search){
		return practiceDao.getRequestAccountPractice(labId, pageNo, pageSize, search);
	}
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的诊所总数
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	@Override
	public Long getRequestAccountPracticeCount(Integer labId,String search){
		return practiceDao.getRequestAccountPracticeCount(labId, search);
	}

	@Override
	public Long updateOperateTime(Practice practice) {
		return practiceDao.updateOperateTime(practice);
	}
	
	/**
	 * 
	 * @Description: 获取所有合作技工间的权限
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	@Override
	public List<Map<String, Object>> getAllPartnerLabAndAuthority(Integer unitId) throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = practiceDao.getAllPartnerLabAndAuthority(unitId);
		
		User sessionUser = userService.getSessionUserByLoginEmail();
		for (int i = 0; i < list.size(); i++) {
			String cases = ToolsKit.TypeConversionUtil.asString(list.get(i).get("cases"));
			String finances = ToolsKit.TypeConversionUtil.asString(list.get(i).get("finances"));
			LabPermissions.Cases casesPermissions = ToolsKit.jsonUitl.toBean(LabPermissions.Cases.class, cases);
			LabPermissions.Finances financesPermissions = ToolsKit.jsonUitl.toBean(LabPermissions.Finances.class, finances);
			list.get(i).put("casesPermissions", casesPermissions);
			list.get(i).put("financesPermissions", financesPermissions);
			
			if(!"true".equals(sessionUser.getIsMain())){
				Map<String, Object> map = ToolsKit.jsonUitl.toBean(Map.class, sessionUser.getLabPermissions());
				String jsonStr = ToolsKit.jsonUitl.toJson(map.get(list.get(i).get("labId")+""));
				casesPermissions = ToolsKit.jsonUitl.toBean(LabPermissions.Cases.class,jsonStr);
				list.get(i).put("casesPermissions", casesPermissions);
				financesPermissions = ToolsKit.jsonUitl.toBean(LabPermissions.Finances.class,jsonStr);
				list.get(i).put("financesPermissions", casesPermissions);
			}
		}
		return list;
	}

	@Override
	public List<Practice> queryPracticeServiedByLabO(Integer labId) {
		return practiceDao.queryPracticeServiedByLabO(labId);
	}

}
