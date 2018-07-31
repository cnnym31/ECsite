package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.BuyProductHistoryDAO;
import com.internousdev.withm.dao.CartInfoDAO;
import com.internousdev.withm.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String userId = String.valueOf(session.get("loginId"));

		BuyProductHistoryDAO buyProductHistoryDAO = new BuyProductHistoryDAO();


		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.cartInfoList(userId);

		int count = 0;

		for (int i = 0; i < cartInfoDTOList.size(); i++) {

			count = buyProductHistoryDAO.insert(userId,
					cartInfoDTOList.get(i).getCategoryId(),
					cartInfoDTOList.get(i).getProductCount(),
					cartInfoDTOList.get(i).getSubtotal());
		}


		if (count > 0) {
			result = SUCCESS;


			count = cartInfoDAO.deleteAll(userId);

			if (count > 0) {
				cartInfoDTOList = cartInfoDAO.cartInfoList(userId);
				Iterator<CartInfoDTO> iteratorCart = cartInfoDTOList.iterator();

				if (!(iteratorCart.hasNext())){
					cartInfoDTOList = null;
				}

				session.put("cartInfoDTOList",cartInfoDTOList);

				int totalPrice = cartInfoDAO.totalPrice(userId);
				session.put("totalPrice", totalPrice);
			}

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
