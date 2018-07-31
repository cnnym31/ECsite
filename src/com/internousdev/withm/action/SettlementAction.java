package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SettlementAction extends ActionSupport implements SessionAware {

	private int productId;
	private int productCount;
	private int productPrice;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		if (!session.containsKey("loginId")) {
			return "login";
		}

		result = SUCCESS;
		return result;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductCount(){
		return productCount;
	}

	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public int getProductPrice(){
		return productPrice;
	}

	public void setProductPrice(int productPrice){
		this.productPrice = productPrice;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
