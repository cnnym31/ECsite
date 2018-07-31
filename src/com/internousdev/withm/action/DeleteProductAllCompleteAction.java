package com.internousdev.withm.action;

import com.internousdev.withm.dao.ProductInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAllCompleteAction extends ActionSupport {

	public String execute() {
		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		int count = productInfoDAO.deleteAll();

		if (count > 0) {
			result = SUCCESS;
		}

		return result;
	}

}
