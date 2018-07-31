package com.internousdev.withm.dto;

import java.util.Date;

public class BuyProductHistoryDTO {

	private int id;
	private String userId;
	private int productId;
	private int productCount;
	private int productPrice;
	private int destinationId;
	private Date insertDate;
	private Date updateDate;

	private String productName;
	private String productNameKana;
	private String imageFileName;

	private int subtotal;

	private String familyName;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
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

	public int getDestinationId(){
		return destinationId;
	}

	public void setDestinationId(int destinationId){
		this.destinationId = destinationId;
	}

	public Date getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName = familyName;
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

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}

	public int getSubtotal(){
		return subtotal;
	}

	public void setSubtotal(int subtotal){
		this.subtotal = subtotal;
	}


}
