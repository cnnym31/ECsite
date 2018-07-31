package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.DestinationInfoDAO;
import com.internousdev.withm.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {

	private int id;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
		destinationInfoDTO = destinationInfoDAO.destinationInfo(id);

		session.put("destinationInfoDTO", destinationInfoDTO);

		result = SUCCESS;
		return result;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
