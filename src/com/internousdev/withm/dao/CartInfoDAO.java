package com.internousdev.withm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.withm.dto.CartInfoDTO;
import com.internousdev.withm.util.DBConnector;

public class CartInfoDAO {

	/* カート情報 */
	public List<CartInfoDTO> cartInfoList(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		String sql = "SELECT"
				+ " ci.id,"
				+ " ci.user_id,"
				+ " ci.temp_user_id,"
				+ " ci.product_id,"
				+ " SUM(ci.product_count) as product_count,"
				+ " pi.product_price,"
				+ " pi.insert_date,"
				+ " pi.update_date,"
				+ " pi.product_name,"
				+ " pi.product_name_kana,"
				+ " pi.product_description,"
				+ " pi.category_id,"
				+ " pi.image_file_name,"
				+ " (SUM(ci.product_count) * pi.product_price) as subtotal"
				+ " FROM cart_info ci LEFT JOIN product_info pi"
				+ " ON ci.product_id = pi.id"
				+ " WHERE ci.user_id=? GROUP BY product_id";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				CartInfoDTO cartInfoDTO = new CartInfoDTO();
				cartInfoDTO.setId(resultSet.getInt("id"));
				cartInfoDTO.setUserId(resultSet.getString("user_id"));
				cartInfoDTO.setTempUserId(resultSet.getString("temp_user_id"));
				cartInfoDTO.setProductId(resultSet.getInt("product_id"));
				cartInfoDTO.setProductCount(resultSet.getInt("product_count"));
				cartInfoDTO.setProductPrice(resultSet.getInt("product_price"));
				cartInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				cartInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				cartInfoDTO.setProductName(resultSet.getString("product_name"));
				cartInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				cartInfoDTO.setProductDescription(resultSet.getString("product_description"));
				cartInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				cartInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				cartInfoDTO.setSubtotal(resultSet.getInt("subtotal"));
				cartInfoDTOList.add(cartInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cartInfoDTOList;
	}

	/* カート内合計金額 */
	public int totalPrice(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;

		String sql = "SELECT SUM(product_count * product_price) as total_price"
				+ " FROM cart_info WHERE user_id=? GROUP BY user_id";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				count = resultSet.getInt("total_price");
			}
		} catch (Exception e){
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}

	/* 追加 */
	public int insert(String userId, int productId, int productCount, int productPrice) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;

		String sql = "INSERT INTO cart_info(user_id, product_id, product_count, product_price, insert_date)"
				+ " VALUES(?, ?, ?, ?, now())";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, productCount);
			preparedStatement.setInt(4, productPrice);
			count = preparedStatement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}

	/* 全削除 */
	public int deleteAll(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;

		String sql = "DELETE FROM cart_info WHERE user_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			count = preparedStatement.executeUpdate();
		} catch (Exception e){
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
