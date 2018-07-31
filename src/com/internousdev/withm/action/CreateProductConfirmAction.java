package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateProductConfirmAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int productPrice;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		session.put("productName", productName);
		session.put("productNameKana", productNameKana);
		session.put("productDescription", productDescription);
		session.put("categoryId", categoryId);
		session.put("productPrice", productPrice);

		result = SUCCESS;
		return result;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
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
