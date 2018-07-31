package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.UserInfoDAO;
import com.internousdev.withm.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoMyPageAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

	public String execute() {
		String result = ERROR;

		/* loginIdが無ければエラーを返す */
		if (!session.containsKey("loginId")) {
			return result;
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		userInfoDTOList = userInfoDAO.userInfoList(String.valueOf(session.get("loginId")));

		if (userInfoDTOList == null) {
			return result;
		}

		session.put("userInfoDTOList", userInfoDTOList);

		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO = userInfoDAO.select(String.valueOf(session.get("loginId")));

		session.put("id", userInfoDTO.getId());

		result = SUCCESS;
		return result;

	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public List<UserInfoDTO> getUserInfoDTOList(){
		return userInfoDTOList;
	}

	public void setUserInfoDTOList(List<UserInfoDTO> userInfoDTOList){
		this.userInfoDTOList = userInfoDTOList;
	}
}
