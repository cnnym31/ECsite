package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.DestinationInfoDAO;
import com.internousdev.withm.dto.DestinationInfoDTO;
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

		String userId = String.valueOf(session.get("loginId"));

		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
		destinationInfoDTOList = destinationInfoDAO.destinationInfoList(userId);

		Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
		if (!(iterator.hasNext())) {
			destinationInfoDTOList = null;
		}

		session.put("destinationInfoDTOList", destinationInfoDTOList);

		System.out.println(destinationInfoDTOList.size());

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
