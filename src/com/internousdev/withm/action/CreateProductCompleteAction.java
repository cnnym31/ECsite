package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.ProductInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateProductCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		int count = productInfoDAO.insert(
				String.valueOf(session.get("productName")),
				String.valueOf(session.get("productNameKana")),
				String.valueOf(session.get("productDescription")),
				Integer.parseInt(session.get("categoryId").toString()),
				Integer.parseInt(session.get("productPrice").toString()));

		if (count > 0) {
			result = SUCCESS;
		}

		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
