package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.CartInfoDAO;
import com.internousdev.withm.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String userId = null;

		/* ログイン時はuserIdにログインIDを代入 */
		if (session.containsKey("loginId")) {
			userId = String.valueOf(session.get("loginId"));
		}

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.cartInfoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if(!(iterator.hasNext())){
			cartInfoDTOList = null;
		}
		session.put("cartInfoDTOList", cartInfoDTOList);

		/* カート合計金額 */
		int totalPrice = cartInfoDAO.totalPrice(userId);
		session.put("totalPrice", totalPrice);

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
