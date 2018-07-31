package com.internousdev.withm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.withm.dto.BuyProductHistoryDTO;
import com.internousdev.withm.util.DBConnector;

public class BuyProductHistoryDAO {

	/* 購入履歴リスト */
	public List<BuyProductHistoryDTO> buyProductHistoryList(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<BuyProductHistoryDTO> buyProductHistoryDTOList = new ArrayList<BuyProductHistoryDTO>();

		String sql = "SELECT"
				+ " bph.id,"
				+ " bph.user_id,"
				+ " bph.product_count,"
				+ " pi.id as product_id,"
				+ " pi.product_name,"
				+ " pi.product_name_kana,"
				+ " pi.product_price,"
				+ " pi.image_file_name,"
				+ " bph.product_price as subtotal,"
				+ " bph.destination_id,"
				+ " bph.insert_date,"
				+ " bph.update_date,"
				+ " di.family_name"
				+ " FROM buy_product_history bph"
				+ " LEFT JOIN product_info pi"
				+ " ON bph.product_id = pi.id"
				+ " LEFT JOIN destination_info di"
				+ " ON bph.destination_id = di.id"
				+ " WHERE bph.user_id=?"
				+ " ORDER BY insert_date DESC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				BuyProductHistoryDTO buyProductHistoryDTO = new BuyProductHistoryDTO();
				buyProductHistoryDTO.setId(resultSet.getInt("id"));
				buyProductHistoryDTO.setUserId(resultSet.getString("user_id"));
				buyProductHistoryDTO.setProductId(resultSet.getInt("product_id"));
				buyProductHistoryDTO.setProductPrice(resultSet.getInt("product_price"));
				buyProductHistoryDTO.setProductCount(resultSet.getInt("product_count"));
				buyProductHistoryDTO.setDestinationId(resultSet.getInt("destination_id"));
				buyProductHistoryDTO.setInsertDate(resultSet.getDate("insert_date"));
				buyProductHistoryDTO.setUpdateDate(resultSet.getDate("update_date"));
				buyProductHistoryDTO.setFamilyName(resultSet.getString("family_name"));
				buyProductHistoryDTO.setProductName(resultSet.getString("product_name"));
				buyProductHistoryDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				buyProductHistoryDTO.setImageFileName(resultSet.getString("image_file_name"));
				buyProductHistoryDTO.setSubtotal(resultSet.getInt("subtotal"));
				buyProductHistoryDTOList.add(buyProductHistoryDTO);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buyProductHistoryDTOList;

	}

	/* 追加 */
	public int insert(String userId, int productId, int productCount, int productPrice, int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;

		String sql = "INSERT INTO buy_product_history(user_id, product_id, product_count, product_price, destination_id, insert_date)"
				+ " VALUES(?, ?, ?, ?, ?, now())";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, productCount);
			preparedStatement.setInt(4, productPrice);
			preparedStatement.setInt(5, id);
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

	/* 履歴全削除 */
	public int deleteAll(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;

		String sql = "DELETE FROM buy_product_history WHERE user_id=?";

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
