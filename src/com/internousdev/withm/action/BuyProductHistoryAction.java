package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.BuyProductHistoryDAO;
import com.internousdev.withm.dto.BuyProductHistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyProductHistoryAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String userId = String.valueOf(session.get("loginId"));

		System.out.println(session.get("loginId"));

		BuyProductHistoryDAO buyProductHistoryDAO = new BuyProductHistoryDAO();
		List<BuyProductHistoryDTO> buyProductHistoryDTOList = new ArrayList<BuyProductHistoryDTO>();
		buyProductHistoryDTOList = buyProductHistoryDAO.buyProductHistoryList(userId);

		System.out.println(buyProductHistoryDAO.buyProductHistoryList(userId));

		Iterator<BuyProductHistoryDTO> iterator = buyProductHistoryDTOList.iterator();
		if (!(iterator.hasNext())) {
			buyProductHistoryDTOList = null;
		}

		session.put("buyProductHistoryDTOList", buyProductHistoryDTOList);

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
}
