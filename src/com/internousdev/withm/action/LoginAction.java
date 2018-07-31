package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.UserInfoDAO;
import com.internousdev.withm.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		/* ログイン */
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO = userInfoDAO.select(userId, password);
		session.put("loginUser", userInfoDTO);

		/* adminでログインした場合に管理者ページへ */
		if (((UserInfoDTO) session.get("loginUser")).getAdmin() == 1) {
			session.put("admin", 1);
			result = "admin";
		} else if (userId.equals(userInfoDTO.getUserId()) && password.equals(userInfoDTO.getPassword())){
			session.put("loginId", userInfoDTO.getUserId());
			session.put("logined", 1);
			result = SUCCESS;
		}

		return result;
	}

	public String getUserId(){
		 return userId;
	 }

	 public void setUserId(String userId){
		 this.userId = userId;
	 }

	 public String getPassword(){
		 return password;
	 }

	 public void setPassword(String password){
		 this.password = password;
	 }

	 public Map<String, Object> getSession(){
		 return session;
	 }

	 @Override
	 public void setSession(Map<String, Object> session){
		 this.session = session;
	 }

}
