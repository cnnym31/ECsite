package com.internousdev.withm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.withm.dto.ProductInfoDTO;
import com.internousdev.withm.util.DBConnector;

public class ProductInfoDAO {

	/* 全ての商品情報を取得 */
	public List<ProductInfoDTO> productInfoList() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setProductPrice(resultSet.getInt("product_price"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTOList;
	}

	/* idから商品情報を取得 */
	public ProductInfoDTO select(int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT * FROM product_info where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setProductPrice(resultSet.getInt("product_price"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTO;
	}

	/* 商品を追加 */
	public int insert(String productName, String productNameKana, String productDescription, int categoryId, int productPrice) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "INSERT INTO product_info(product_name, product_name_kana, product_description,"
				+ " category_id, product_price, insert_date)"
				+ " VALUES(?, ?, ?, ?, ?, now())";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2,  productNameKana);
			preparedStatement.setString(3,  productDescription);
			preparedStatement.setInt(4, categoryId);
			preparedStatement.setInt(5, productPrice);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}

	/* 商品情報更新 */
	public int update(String productName, String productNameKana, String productDescription,
			int categoryId,int productPrice, int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "UPDATE product_info SET product_name=?, product_name_kana=?, product_description=?,"
				+ " category_id=?, product_price=?, update_date=now()"
				+  "WHERE id=?";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2,  productNameKana);
			preparedStatement.setString(3,  productDescription);
			preparedStatement.setInt(4, categoryId);
			preparedStatement.setInt(5, productPrice);
			preparedStatement.setInt(6, id);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}

	/* 商品削除 */
	public int delete(int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM product_info WHERE id=?";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}

	/* 商品全削除 */
	public int deleteAll() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM product_info";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}
}
