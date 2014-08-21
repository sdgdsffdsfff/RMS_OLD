package com.cqupt.mis.rms.action;

import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LM
 *
 */
@SuppressWarnings("serial")
public class ConfirmAction extends ActionSupport {
	private String isSuccess;	
	private String message;
	private String url;
	private String retName;
	
	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRetName() {
		return retName;
	}

	public void setRetName(String retName) {
		this.retName = retName;
	}

	public String execute() throws Exception {
		Confirm confirm = (Confirm)ActionContext.getContext().get("confirm");
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

}
