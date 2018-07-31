package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.ProductInfoDAO;
import com.internousdev.withm.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productNameKana;
	private int productPrice;
	private String imageFileName;

	private String categoryId;
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.productInfoList();
		session.put("productInfoDTOList", productInfoDTOList);

		result = SUCCESS;
		return result;

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
