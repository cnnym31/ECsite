package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.ProductInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProductCompleteAction extends ActionSupport implements SessionAware {

	private int id;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		int count = productInfoDAO.update(
				String.valueOf(session.get("productName")),
				String.valueOf(session.get("productNameKana")),
				String.valueOf(session.get("productDescription")),
				Integer.parseInt(session.get("categoryId").toString()),
				Integer.parseInt(session.get("productPrice").toString()),
				id);

		if (count > 0) {
			result = SUCCESS;
		}

		return result;
	}

	public int id(){
		return id;
	}

	public void setId(int id) {
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
