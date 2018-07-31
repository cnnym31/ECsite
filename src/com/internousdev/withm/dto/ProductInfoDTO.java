package com.internousdev.withm.dto;

import java.util.Date;

public class ProductInfoDTO {

	private int id;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int productPrice;
	private String imageFileName;
	private Date insertDate;
	private Date updateDate;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
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

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
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

}
