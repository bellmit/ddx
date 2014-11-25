package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "ddx_user_reset_password")
public class ResetPassword implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resetemail;
	private String resettype;
	private String resetpassword;
	private Integer resetwhether;
	@Id
	@Column(name="RESET_EMAIL")
	public String getResetemail() {
		return resetemail;
	}
	public void setResetemail(String resetemail) {
		this.resetemail = resetemail;
	}
	@Column(name="RESET_TYPE")
	public String getResettype() {
		return resettype;
	}
	public void setResettype(String resettype) {
		this.resettype = resettype;
	}
	@Column(name="RESET_PASSWORD")
	public String getResetpassword() {
		return resetpassword;
	}
	public void setResetpassword(String resetpassword) {
		this.resetpassword = resetpassword;
	}
	@Column(name="RESET_WHETHER")
	public Integer getResetwhether() {
		return resetwhether;
	}
	public void setResetwhether(Integer resetwhether) {
		this.resetwhether = resetwhether;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
