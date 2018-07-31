package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.delete(Integer.parseInt(session.get("id").toString()));

		if (count > 0) {
			session.clear();
			session.put("logined", 0);

			result = SUCCESS;
		}

		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
