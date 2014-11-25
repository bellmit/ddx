/**   
 * @Title: LabProcedurePojo.java 
 * @Package com.upcera.ddx.pojo 
 * @author ERIC
 * @company UPCERA
 * @date 2014-9-2 上午09:11:30 
 * @version V1.0   
 */
package com.upcera.ddx.pojo;

/**
 * @ClassName: LabProcedurePojo
 * @Description: 用于解析订单中的工序json字符串
 * @author ERIC
 * @date 2014-9-2 上午09:11:30
 * 
 */

public class LabProcedurePojo {
	private String procedure_id;
	private String index;

	public String getProcedure_id() {
		return procedure_id;
	}

	public String getIndex() {
		return index;
	}

	public void setProcedure_id(String procedure_id) {
		this.procedure_id = procedure_id;
	}

	public void setIndex(String index) {
		this.index = index;
	}

}
