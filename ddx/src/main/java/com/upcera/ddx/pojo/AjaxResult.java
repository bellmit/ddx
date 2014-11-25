package com.upcera.ddx.pojo;
/**
 * 用戶ajax請求
 * @author 金德志
 *
 */
public class AjaxResult {
	private Booleans result;
	private String failReasons;
	private Object info;

	public AjaxResult() {
	}

	public AjaxResult(Booleans booleans, String failReasons) {
		this.result = booleans;
		this.failReasons = failReasons;
	}

	public Booleans getResult() {
		return result;
	}

	public void setResult(Booleans booleans) {
		this.result = booleans;
	}

	public String getFailReasons() {
		return failReasons;
	}

	public void setFailReasons(String failReasons) {
		this.failReasons = failReasons;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public enum Booleans {
		TRUE, FALSE;
	}
}
