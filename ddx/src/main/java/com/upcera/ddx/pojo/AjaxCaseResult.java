/**   
 * @Title: AjaxCaseResult.java 
 * @Package com.upcera.ddx.pojo 
 * @author ERIC
 * @company UPCERA
 * @date 2014-8-11 下午04:44:00 
 * @version V1.0   
 */ 
package com.upcera.ddx.pojo;

import java.sql.Timestamp;
import java.util.Date;

/** 
 * @ClassName: AjaxCaseResult 
 * @Description: 订单操作返回类 
 * @author ERIC
 * @date 2014-8-11 下午04:44:00 
 *  
 */

public class AjaxCaseResult {
	
	public CasesTmp[] ct;
	
	private Boolean success;
	
	public CasesTmp[] getCt() {
		return ct;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setCt(CasesTmp[] ct) {
		this.ct = ct;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public static class CasesTmp{
		
		private Date date;

		private Integer id;

		private String msg;

		private Timestamp timestamp;

		public Date getDate() {
			return date;
		}

		public Integer getId() {
			return id;
		}

		public String getMsg() {
			return msg;
		}

		public Timestamp getTimestamp() {
			return timestamp;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}
	}
	
}
