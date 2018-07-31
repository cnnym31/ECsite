package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.CartInfoDAO;
import com.internousdev.withm.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware {

	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String imageFileName;
	private int productCount;
	private int productPrice;
	private Date insertDate;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String userId = String.valueOf(session.get("loginId"));

		if(!session.containsKey("loginId")) {
			result = "login";
			return result;
		}

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int count = cartInfoDAO.insert(userId, productId, productCount, productPrice);

		if (count > 0){
			result = SUCCESS;
		}

		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.cartInfoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if(!(iterator.hasNext())){
			cartInfoDTOList = null;
		}
		session.put("cartInfoDTOList", cartInfoDTOList);

		/* 合計金額 */
		int totalPrice = cartInfoDAO.totalPrice(userId);
		session.put("totalPrice", totalPrice);

		return result;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
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

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
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

	public Date getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
