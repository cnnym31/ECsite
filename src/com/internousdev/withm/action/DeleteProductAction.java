package com.internousdev.withm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.ProductInfoDAO;
import com.internousdev.withm.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAction extends ActionSupport implements SessionAware {

	private int id;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		productInfoDTO = productInfoDAO.select(id);

		session.put("id", productInfoDTO.getId());
		session.put("productName",productInfoDTO.getProductName());
		session.put("productNameKana",productInfoDTO.getProductNameKana());
		session.put("productDescription",productInfoDTO.getProductDescription());
		session.put("categoryId",productInfoDTO.getCategoryId());
		session.put("productPrice",productInfoDTO.getProductPrice());
		session.put("imageFileName", productInfoDTO.getImageFileName());

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
