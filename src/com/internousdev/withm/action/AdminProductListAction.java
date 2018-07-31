package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.ProductInfoDAO;
import com.internousdev.withm.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminProductListAction extends ActionSupport{

	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

	public String execute() {
		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.productInfoList();

		result = SUCCESS;
		return result;
	}

	public List<ProductInfoDTO> getProductInfoDTOList(){
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList){
		this.productInfoDTOList= productInfoDTOList;
	}

}
