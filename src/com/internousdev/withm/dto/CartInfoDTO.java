package com.internousdev.withm.dto;

import java.util.Date;

public class CartInfoDTO {

	private int id;
	private String userId;
	private String tempUserId;
	private int productId;
	private int productCount;
	private int productPrice;
	private Date insertDate;
	private Date updateDate;

	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private String imageFileName;
	private int subtotal;

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

	public String getTempUserId(){
		return tempUserId;
	}

	public void setTempUserId(String tempUserId){
		this.tempUserId = tempUserId;
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
