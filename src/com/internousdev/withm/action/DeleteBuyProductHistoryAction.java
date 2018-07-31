package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.BuyProductHistoryDAO;
import com.internousdev.withm.dto.BuyProductHistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteBuyProductHistoryAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String userId = String.valueOf(session.get("loginId"));

		BuyProductHistoryDAO buyProductHistoryDAO = new BuyProductHistoryDAO();
		int count = buyProductHistoryDAO.deleteAll(userId);

		if (count > 0) {
			List<BuyProductHistoryDTO> buyProductHistoryDTOList = new ArrayList<BuyProductHistoryDTO>();
			buyProductHistoryDTOList = buyProductHistoryDAO.buyProductHistoryList(userId);

			Iterator<BuyProductHistoryDTO> iterator = buyProductHistoryDTOList.iterator();
			if (!(iterator.hasNext())) {
				buyProductHistoryDTOList = null;
			}

			session.put("buyProductHistoryDTOList", buyProductHistoryDTOList);

		}

		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
